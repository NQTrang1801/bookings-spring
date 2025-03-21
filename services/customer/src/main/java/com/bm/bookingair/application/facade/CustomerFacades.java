package com.bm.bookingair.application.facade;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.presentation.dto.req.CustomerReqDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerFacades {
    CustomerData createCustomer(@Valid CustomerReqDTO customerReqDTO);

    CustomerData getCustomerById(String id);

    List<CustomerData> getAllCustomers();

    CustomerData updateCustomer(String id, @Valid CustomerReqDTO customerReqDTO);

    void deleteCustomer(String id);
}
