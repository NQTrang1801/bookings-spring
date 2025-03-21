package com.bm.bookingair.domain.service;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.domain.model.Customer;

import java.util.Collection;

public interface CustomerService {
    Customer createCustomer(CustomerData customer);

    Customer getCustomerById(String id);

    Collection<Customer> getAllCustomers();

    Customer updateCustomer(String id, CustomerData customerData);

    void deleteCustomer(String id);
}
