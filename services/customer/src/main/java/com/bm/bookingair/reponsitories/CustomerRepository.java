package com.bm.bookingair.reponsitories;

import com.bm.bookingair.models.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    
}
