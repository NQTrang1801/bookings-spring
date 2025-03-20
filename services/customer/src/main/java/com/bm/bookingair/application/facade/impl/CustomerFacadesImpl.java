package com.bm.bookingair.application.facade.impl;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.presentation.dto.req.CustomerReqDTO;
import com.bm.bookingair.application.facade.CustomerFacades;
import com.bm.bookingair.application.populator.impl.customer.CustomerDTOToDataPopulator;
import com.bm.bookingair.application.populator.impl.customer.CustomerModelToDataPopulor;
import com.bm.bookingair.domain.service.CustomerService;
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
