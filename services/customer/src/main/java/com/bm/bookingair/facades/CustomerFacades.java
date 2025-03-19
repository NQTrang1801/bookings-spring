package com.bm.bookingair.facades;

import com.bm.bookingair.data.customer.CustomerData;
import com.bm.bookingair.dtos.req.CustomerReqDTO;
import jakarta.validation.Valid;

public interface CustomerFacades {
    CustomerData createCustomer(@Valid CustomerReqDTO customerReqDTO);
}
