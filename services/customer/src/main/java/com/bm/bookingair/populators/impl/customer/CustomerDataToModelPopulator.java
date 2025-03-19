package com.bm.bookingair.populators.impl.customer;

import com.bm.bookingair.data.customer.CustomerData;
import com.bm.bookingair.models.address.Address;
import com.bm.bookingair.models.customer.Customer;
import com.bm.bookingair.populators.Populator;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataToModelPopulator implements Populator<CustomerData, Customer> {

    @Override
    public void populate(CustomerData source, Customer target) {
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhone(source.getPhone());
        target.setEmail(source.getEmail());
        if (source.getAddress() != null) {
            target.setAddress(Address.builder()
                            .street(source.getAddress().getStreet())
                            .city(source.getAddress().getCity())
                            .country(source.getAddress().getCountry())
                            .build());
        }
    }
}
