package com.bm.bookingair.services.impl;

import com.bm.bookingair.data.customer.CustomerData;
import com.bm.bookingair.models.customer.Customer;
import com.bm.bookingair.populators.impl.customer.CustomerDataToModelPopulator;
import com.bm.bookingair.reponsitories.CustomerRepository;
import com.bm.bookingair.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerDataToModelPopulator customerPopular;

    @Override
    public Customer createCustomer(CustomerData customerData) {
        Customer customer = new Customer();
        customerPopular.populate(customerData, customer);
        repository.save(customer);
        return customer;
    }
}
