package com.bm.bookingair.populators.impl.customer;

import com.bm.bookingair.data.address.AddressData;
import com.bm.bookingair.data.customer.CustomerData;
import com.bm.bookingair.models.customer.Customer;
import com.bm.bookingair.populators.Populator;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelToDataPopulor implements Populator<Customer, CustomerData> {

    @Override
    public void populate(Customer source, CustomerData target) {
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhone(source.getPhone());
        target.setEmail(source.getEmail());
        if (source.getAddress() != null) {
            target.setAddress(AddressData.builder()
                    .street(source.getAddress().getStreet())
                    .city(source.getAddress().getCity())
                    .country(source.getAddress().getCountry())
                    .build());
        }
    }

}
