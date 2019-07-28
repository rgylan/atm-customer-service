package com.rgy.atm.service;

import com.rgy.atm.dto.CustomerDTO;
import com.rgy.atm.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO findCustomer(Long id) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerRepository.findById(id).ifPresent(customerEntity -> {
            BeanUtils.copyProperties(customerEntity, customerDTO);
        });
        LOGGER.info("Customer found: {}", customerDTO);

        return customerDTO;
    }
}
