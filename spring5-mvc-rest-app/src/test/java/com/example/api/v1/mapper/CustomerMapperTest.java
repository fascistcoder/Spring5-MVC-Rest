package com.example.api.v1.mapper;

import com.example.api.v1.model.CustomerDTO;
import com.example.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/12/21
 */
class CustomerMapperTest {

    public static final String FIRSTNAME = "Joe";
    public static final String LASTNAME = "Root";

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTO() {

        //given
        Customer customer = new Customer();
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTNAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTNAME, customerDTO.getLastname());
    }
}