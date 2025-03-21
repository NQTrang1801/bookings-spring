package com.bm.bookingair.application.facade.impl;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.presentation.dto.req.CustomerReqDTO;
import com.bm.bookingair.application.facade.CustomerFacades;
import com.bm.bookingair.application.populator.impl.customer.CustomerDTOToDataPopulator;
import com.bm.bookingair.application.populator.impl.customer.CustomerModelToDataPopulor;
import com.bm.bookingair.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerFacadesImpl implements CustomerFacades {
    private final CustomerDTOToDataPopulator customerDTOToDataPopular;
    private final CustomerModelToDataPopulor customerModelToDataPopular;
    private final CustomerService customerService;

    @Override
    public CustomerData createCustomer(CustomerReqDTO customerReqDTO) {
        CustomerData customerData = new CustomerData();
        customerDTOToDataPopular.populate(customerReqDTO, customerData);
        customerModelToDataPopular.populate(customerService.createCustomer(customerData), customerData);
        return customerData;
    }

    @Override
    public CustomerData getCustomerById(String id) {
        CustomerData customerData = new CustomerData();
        customerModelToDataPopular.populate(customerService.getCustomerById(id), customerData);
        return customerData;
    }

    @Override
    public List<CustomerData> getAllCustomers() {
        return customerService.getAllCustomers()
                .stream()
                .map(customer -> {
                    CustomerData customerData = new CustomerData();
                    customerModelToDataPopular.populate(customer, customerData);
                    return customerData;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerData updateCustomer(String id, CustomerReqDTO customerReqDTO) {
        CustomerData customerData = new CustomerData();
        customerDTOToDataPopular.populate(customerReqDTO, customerData);
        customerModelToDataPopular.populate(customerService.updateCustomer(id, customerData), customerData);
        return customerData;
    }

    @Override
    public void deleteCustomer(String id) {
        customerService.deleteCustomer(id);
    }
}
