package com.rgy.atm.controller;

import com.rgy.atm.dto.CustomerDTO;
import com.rgy.atm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> findCustomer(@PathVariable Long id) {
        /*CustomerDTO customer = new CustomerDTO();
        customer.setId(123L);
        customer.setFirstName("Samantha Anne");
        customer.setLastName("Ylannn");*/

        return new ResponseEntity<>(customerService.findCustomer(id), HttpStatus.OK);
    }
}
