package com.bm.bookingair.application.facade;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.presentation.dto.req.CustomerReqDTO;
import jakarta.validation.Valid;

public interface CustomerFacades {
    CustomerData createCustomer(@Valid CustomerReqDTO customerReqDTO);
}
