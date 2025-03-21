package com.bm.bookingair.application.populator.impl.customer;

import com.bm.bookingair.common.enums.Gender;
import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.application.dataModel.address.AddressData;
import com.bm.bookingair.presentation.dto.req.CustomerReqDTO;
import com.bm.bookingair.application.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOToDataPopulator implements Populator<CustomerReqDTO, CustomerData> {

    @Override
    public void populate(CustomerReqDTO source, CustomerData target) {
        target.setFirstName(source.firstName());
        target.setLastName(source.lastName());
        target.setGender(source.gender());
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
