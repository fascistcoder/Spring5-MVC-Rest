package com.example.services;

import com.example.api.v1.mapper.CustomerMapper;
import com.example.api.v1.model.CustomerDTO;
import com.example.repositories.CustomerRepository;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/12/21
 */
public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    void setCustomerRepository(CustomerRepository customerRepository);

    void setCustomerMapper(CustomerMapper customerMapper);
}
