package com.rgy.atm.service;

import com.rgy.atm.dto.CustomerDTO;

public interface CustomerService {

    /**
     *
     *
     * @param id
     * @return
     */
    CustomerDTO findCustomer(Long id);
}
