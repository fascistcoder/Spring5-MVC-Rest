package com.example.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/03/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    @Schema(description = "This is the name", required = true)
    private String name;

    @JsonProperty("vendor_url")
    private String vendorUrl;
}
