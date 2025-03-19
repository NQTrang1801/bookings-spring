package com.bm.bookingair.services;

import com.bm.bookingair.data.customer.CustomerData;
import com.bm.bookingair.models.customer.Customer;

public interface CustomerService {
    Customer createCustomer(CustomerData customer);
}
