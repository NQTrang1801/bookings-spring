package com.bm.bookingair.domain.service.impl;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.domain.model.customer.Customer;
import com.bm.bookingair.application.populator.impl.customer.CustomerDataToModelPopulator;
import com.bm.bookingair.domain.repository.CustomerRepository;
import com.bm.bookingair.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDataToModelPopulator customerPopular;

    @Override
    public Customer createCustomer(CustomerData customerData) {
        Customer customer = new Customer();
        customerPopular.populate(customerData, customer);
        customerRepository.save(customer);
        return customer;
    }
}
