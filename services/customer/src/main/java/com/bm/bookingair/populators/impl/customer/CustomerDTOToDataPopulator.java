package com.bm.bookingair.populators.impl.customer;

import com.bm.bookingair.commons.enums.Gender;
import com.bm.bookingair.data.customer.CustomerData;
import com.bm.bookingair.data.address.AddressData;
import com.bm.bookingair.dtos.req.CustomerReqDTO;
import com.bm.bookingair.populators.Populator;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOToDataPopulator implements Populator<CustomerReqDTO, CustomerData> {

    @Override
    public void populate(CustomerReqDTO source, CustomerData target) {
        target.setFirstName(source.firstName());
        target.setLastName(source.lastName());
        target.setGender(Gender.valueOf(source.gender().name()));
        target.setEmail(source.email());
        target.setPhone(source.phone());
        if (source.address() != null) {
            target.setAddress(AddressData.builder()
                    .street(source.address().street())
                    .city(source.address().city())
                    .country(source.address().country())
                    .build());
        }
    }
}
