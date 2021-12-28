package com.example.repositories;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/12/21
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
