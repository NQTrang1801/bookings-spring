package com.bm.bookingair.domain.repository;

import com.bm.bookingair.domain.model.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    
}
