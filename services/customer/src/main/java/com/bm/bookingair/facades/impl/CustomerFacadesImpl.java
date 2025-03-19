package com.bm.bookingair.facades.impl;

import com.bm.bookingair.data.customer.CustomerData;
import com.bm.bookingair.dtos.req.CustomerReqDTO;
import com.bm.bookingair.facades.CustomerFacades;
import com.bm.bookingair.populators.impl.customer.CustomerDTOToDataPopulator;
import com.bm.bookingair.populators.impl.customer.CustomerModelToDataPopulor;
import com.bm.bookingair.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
