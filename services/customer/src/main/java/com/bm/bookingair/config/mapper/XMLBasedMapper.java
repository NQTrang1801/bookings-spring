package com.bm.bookingair.config.mapper;

import com.bm.bookingair.commons.constants.AppConstants;
import org.springframework.stereotype.Component;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class XMLBasedMapper implements GenericMapper<Object, Object> {
    private static final Logger LOGGER = Logger.getLogger(XMLBasedMapper.class.getName());
    private final Map<String, Map<String, String>> mappings = new HashMap<>();

    public XMLBasedMapper() {
        loadMappings(AppConstants.CUSTOMER_MAPPING_CONFIG);
    }

    private void loadMappings(String xmlFile) {
        try {
            File file = new File(xmlFile);
            if (!file.exists()) {
                throw new RuntimeException("Mapping configuration file not found: " + xmlFile);
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList groupNodes = document.getElementsByTagName("GroupMapping");

            for (int i = 0; i < groupNodes.getLength(); i++) {
                Element groupElement = (Element) groupNodes.item(i);
                String className = groupElement.getAttribute("name"); // Lấy tên class từ GroupMapping

                if (className.isEmpty()) {
                    throw new RuntimeException("Missing 'name' attribute in GroupMapping");
                }

                NodeList objectNodes = groupElement.getElementsByTagName("ObjectMapping");

                for (int j = 0; j < objectNodes.getLength(); j++) {
                    Element objectElement = (Element) objectNodes.item(j);
                    String level = objectElement.getAttribute("name");

                    if (level.isEmpty()) {
                        throw new RuntimeException("Missing 'name' attribute in ObjectMapping");
                    }

                    String mappingKey = className + "." + level;

                    NodeList fieldNodes = objectElement.getElementsByTagName("Field");
                    Map<String, String> fieldMap = new HashMap<>();

                    for (int k = 0; k < fieldNodes.getLength(); k++) {
                        Element fieldElement = (Element) fieldNodes.item(k);
                        fieldMap.put(fieldElement.getAttribute("source"), fieldElement.getAttribute("target"));
                    }

                    mappings.put(mappingKey, fieldMap);
                }
            }
        } catch (Exception e) {
            LOGGER.severe("Error loading XML mappings: " + e.getMessage());
            throw new RuntimeException("Failed to load XML mappings", e);
        }
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

            for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                setNestedField(source, target, entry.getKey(), entry.getValue());
            }

            return target;
        } catch (Exception e) {
            throw new RuntimeException("Mapping error: " + e.getMessage(), e);
        }
    }

    private void setNestedField(Object source, Object target, String sourcePath, String targetPath) throws Exception {
        Object sourceValue = getNestedFieldValue(source, sourcePath);
        if (sourceValue != null) {
            setNestedFieldValue(target, targetPath, sourceValue);
        }
    }

    private Object getNestedFieldValue(Object obj, String fieldPath) throws Exception {
        String[] fields = fieldPath.split("\\.");
        Object currentObj = obj;

        for (String field : fields) {
            if (currentObj == null) return null;
            Field declaredField = currentObj.getClass().getDeclaredField(field);
            declaredField.setAccessible(true);
            currentObj = declaredField.get(currentObj);
        }

        return currentObj;
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

        if (finalField.getType().isEnum() && value.getClass().isEnum()) {
            @SuppressWarnings({ "unchecked", "rawtypes" })
            Enum<?> enumValue = Enum.valueOf((Class<Enum>) finalField.getType(), ((Enum<?>) value).name());
            finalField.set(currentObj, enumValue);
        } else {
            finalField.set(currentObj, value);
        }
    }

}
