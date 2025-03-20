package com.bm.bookingair.domain.service;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.domain.model.customer.Customer;

public interface CustomerService {
    Customer createCustomer(CustomerData customer);
}
