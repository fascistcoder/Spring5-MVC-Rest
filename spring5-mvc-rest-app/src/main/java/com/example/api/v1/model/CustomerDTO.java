package com.example.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/12/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @Schema(description = "This is the first name", required = true)
    private String firstname;

    @Schema(required = true)
    private String lastname;

    @JsonProperty("customer_url")
    private String customerUrl;
}
