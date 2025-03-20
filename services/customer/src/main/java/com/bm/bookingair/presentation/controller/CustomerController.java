package com.bm.bookingair.presentation.controller;

import com.bm.bookingair.application.dataModel.customer.CustomerData;
import com.bm.bookingair.common.mapper.XMLBasedMapper;
import com.bm.bookingair.presentation.dto.req.CustomerReqDTO;
import com.bm.bookingair.presentation.dto.res.CustomerResDTO;
import com.bm.bookingair.application.facade.CustomerFacades;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerFacades customerFacades;
    private final XMLBasedMapper xmlBasedMapper;

    @PostMapping
    public ResponseEntity<CustomerResDTO> createCustomer(
            @RequestBody @Valid CustomerReqDTO customerReqDTO,
            @RequestParam(required = false, defaultValue = "DEFAULT") String level
    ) {
        CustomerData customerData = customerFacades.createCustomer(customerReqDTO);
        CustomerResDTO response = xmlBasedMapper.map(customerData, CustomerResDTO.class, level);
        return ResponseEntity.ok(response);
    }
}
