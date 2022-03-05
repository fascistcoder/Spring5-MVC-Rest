package com.example.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/03/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorListDTO {
    List<VendorDTO> vendors;
}
