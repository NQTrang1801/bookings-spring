package com.bm.bookingair.application.populator.impl.customer;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.common.enums.Gender;
import com.bm.bookingair.domain.model.Address;
import com.bm.bookingair.domain.model.Customer;
import com.bm.bookingair.application.populator.Populator;
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
