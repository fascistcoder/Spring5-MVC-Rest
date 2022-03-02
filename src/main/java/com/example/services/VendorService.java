package com.example.services;

import com.example.api.v1.model.VendorDTO;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/03/22
 */
public interface VendorService {
    List<VendorDTO> getAllVendors();

    VendorDTO getVendorsById(Long id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);
}
