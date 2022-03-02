package com.example.repositories;

import com.example.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/03/22
 */
public interface VendorRepository  extends JpaRepository<Vendor, Long> {
}
