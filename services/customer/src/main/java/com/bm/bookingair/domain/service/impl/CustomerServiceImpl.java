package com.bm.bookingair.domain.service.impl;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.common.constant.ErrorMessageConstants;
import com.bm.bookingair.domain.model.Customer;
import com.bm.bookingair.application.populator.impl.customer.CustomerDataToModelPopulator;
import com.bm.bookingair.domain.repository.CustomerRepository;
import com.bm.bookingair.domain.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(ErrorMessageConstants.CUSTOMER_NOT_FOUND, id)
                ));
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(String id, CustomerData customerData) {
        Customer customer = getCustomerById(id);
        customerPopular.populate(customerData, customer);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
