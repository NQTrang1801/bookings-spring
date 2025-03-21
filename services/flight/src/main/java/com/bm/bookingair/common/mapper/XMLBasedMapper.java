package com.bm.bookingair.common.mapper;

import com.bm.bookingair.common.constant.AppConstants;
import org.springframework.stereotype.Component;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;

@Component
public class XMLBasedMapper implements GenericMapper<Object, Object> {
    private static final Logger LOGGER = Logger.getLogger(XMLBasedMapper.class.getName());
    private final Map<String, Map<String, String>> mappings = new HashMap<>();

    public XMLBasedMapper() {
        loadMappings(AppConstants.MAPPING_CONFIG);
    }

    private void loadMappings(String xmlFile) {
        File file = new File(xmlFile);
        if (!file.exists()) {
            throw new RuntimeException("Mapping configuration file not found: " + xmlFile);
        }

        try {
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(file);
            document.getDocumentElement().normalize();

            NodeList groupNodes = document.getElementsByTagName("GroupMapping");

            for (int i = 0; i < groupNodes.getLength(); i++) {
                Element groupElement = (Element) groupNodes.item(i);
                String className = getRequiredAttribute(groupElement, "name");

                NodeList objectNodes = groupElement.getElementsByTagName("ObjectMapping");
                for (int j = 0; j < objectNodes.getLength(); j++) {
                    Element objectElement = (Element) objectNodes.item(j);
                    String level = getRequiredAttribute(objectElement, "name");

                    Map<String, String> fieldMap = mappings.computeIfAbsent(className + "." + level, k -> new HashMap<>());
                    NodeList fieldNodes = objectElement.getElementsByTagName("Field");

                    for (int k = 0; k < fieldNodes.getLength(); k++) {
                        Element fieldElement = (Element) fieldNodes.item(k);
                        fieldMap.put(fieldElement.getAttribute("source"), fieldElement.getAttribute("target"));
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.severe("Error loading XML mappings: " + e.getMessage());
            throw new RuntimeException("Failed to load XML mappings", e);
        }
    }

    private String getRequiredAttribute(Element element, String attrName) {
        String value = element.getAttribute(attrName);
        if (value.isEmpty()) {
            throw new RuntimeException("Missing '" + attrName + "' attribute in " + element.getTagName());
        }
        return value;
    }

    @Override
    public <T> T map(Object source, Class<T> targetType, String level) {
        try {
            T target = targetType.getDeclaredConstructor().newInstance();
            String mappingKey = targetType.getSimpleName() + "." + level;

            Map<String, String> fieldMap = mappings.get(mappingKey);
            if (fieldMap == null) {
                throw new RuntimeException("Mapping type " + mappingKey + " not found!");
            }

            fieldMap.forEach((src, tgt) -> {
                try {
                    setNestedField(source, target, src, tgt);
                } catch (Exception e) {
                    throw new RuntimeException("Mapping error: " + e.getMessage(), e);
                }
            });

            return target;
        } catch (Exception e) {
            throw new RuntimeException("Mapping error: " + e.getMessage(), e);
        }
    }

    private void setNestedField(Object source, Object target, String sourcePath, String targetPath) throws Exception {
        getNestedFieldValue(source, sourcePath)
                .ifPresent(value -> {
                    try {
                        setNestedFieldValue(target, targetPath, value);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private Optional<Object> getNestedFieldValue(Object obj, String fieldPath) {
        try {
            for (String field : fieldPath.split("\\.")) {
                if (obj == null) return Optional.empty();
                Field declaredField = obj.getClass().getDeclaredField(field);
                declaredField.setAccessible(true);
                obj = declaredField.get(obj);
            }
            return Optional.ofNullable(obj);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private void setNestedFieldValue(Object obj, String fieldPath, Object value) throws Exception {
        String[] fields = fieldPath.split("\\.");
        Object currentObj = obj;

        for (int i = 0; i < fields.length - 1; i++) {
            Field declaredField = currentObj.getClass().getDeclaredField(fields[i]);
            declaredField.setAccessible(true);

            Object fieldValue = declaredField.get(currentObj);
            if (fieldValue == null) {
                fieldValue = declaredField.getType().getDeclaredConstructor().newInstance();
                declaredField.set(currentObj, fieldValue);
            }
            currentObj = fieldValue;
        }

        Field finalField = currentObj.getClass().getDeclaredField(fields[fields.length - 1]);
        finalField.setAccessible(true);
        finalField.set(currentObj, convertValue(finalField.getType(), value));
    }

    private Object convertValue(Class<?> fieldType, Object value) {
        if (fieldType.isEnum()) {
            return Enum.valueOf((Class<Enum>) fieldType, value instanceof Enum ? ((Enum<?>) value).name() : value.toString());
        }
        return value instanceof Enum ? ((Enum<?>) value).name() : value;
    }
}
