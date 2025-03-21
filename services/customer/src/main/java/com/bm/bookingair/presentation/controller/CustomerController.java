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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerFacades customerFacades;
    private final XMLBasedMapper xmlBasedMapper;

    @PostMapping
    public CustomerResDTO createCustomer(
            @RequestBody @Valid CustomerReqDTO customerReqDTO,
            @RequestParam(required = false, defaultValue = "DEFAULT") String level
    ) {
        CustomerData customerData = customerFacades.createCustomer(customerReqDTO);
        return xmlBasedMapper.map(customerData, CustomerResDTO.class, level);
    }

    @GetMapping("/{id}")
    public CustomerResDTO getCustomerById(
            @PathVariable String id,
            @RequestParam(required = false, defaultValue = "DEFAULT") String level
    ) {
        CustomerData customerData = customerFacades.getCustomerById(id);
        return xmlBasedMapper.map(customerData, CustomerResDTO.class, level);
    }


    @GetMapping
    public List<CustomerResDTO> getAllCustomers(
            @RequestParam(required = false, defaultValue = "DEFAULT") String level
    ) {
        List<CustomerData> customers = customerFacades.getAllCustomers();
        return customers.stream()
                .map(customer -> xmlBasedMapper.map(customer, CustomerResDTO.class, level))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public CustomerResDTO updateCustomer(
            @PathVariable String id,
            @RequestBody @Valid CustomerReqDTO customerReqDTO,
            @RequestParam(required = false, defaultValue = "DEFAULT") String level
    ) {
        CustomerData updatedCustomer = customerFacades.updateCustomer(id, customerReqDTO);
        return xmlBasedMapper.map(updatedCustomer, CustomerResDTO.class, level);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerFacades.deleteCustomer(id);
    }
}
