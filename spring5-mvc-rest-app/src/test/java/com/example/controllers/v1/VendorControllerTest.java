package com.example.controllers.v1;

import com.example.api.v1.model.VendorDTO;
import com.example.controllers.RestResponseEntityExceptionHandler;
import com.example.services.VendorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static com.example.controllers.v1.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/03/22
 */
class VendorControllerTest {

    @Mock
    VendorService vendorService;

    @InjectMocks
    VendorController vendorController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(vendorController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @Test
    void getAllVendors() throws Exception {
        VendorDTO vendor1 = new VendorDTO();
        vendor1.setName("Michael");
        vendor1.setVendorUrl(VendorController.BASE_URL + "/1");

        VendorDTO vendor2 = new VendorDTO();
        vendor2.setName("John");
        vendor2.setVendorUrl(VendorController.BASE_URL + "/2");

        when(vendorService.getAllVendors()).thenReturn(Arrays.asList(vendor1, vendor2));

        mockMvc.perform(get(VendorController.BASE_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendors", hasSize(2)));
    }

    @Test
    void getVendorsById() throws Exception {
        VendorDTO vendor1 = new VendorDTO();
        vendor1.setName("Michael");
        vendor1.setVendorUrl(VendorController.BASE_URL + "/1");

        when(vendorService.getVendorsById(anyLong())).thenReturn(vendor1);

        mockMvc.perform(get(VendorController.BASE_URL + "/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Michael")));
    }

    @Test
    void createdNewVendor() throws Exception {
        VendorDTO vendor1 = new VendorDTO();
        vendor1.setName("Michael");

        VendorDTO returnDTO = new VendorDTO();
        returnDTO.setName(vendor1.getName());
        returnDTO.setVendorUrl(VendorController.BASE_URL + "/1");

        when(vendorService.createNewVendor(vendor1)).thenReturn(returnDTO);

        //when/then
        mockMvc.perform(post(VendorController.BASE_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(vendor1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo("Michael")))
                .andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/1")));
    }

    @Test
    void updateVendor() throws Exception {
        VendorDTO vendor1 = new VendorDTO();
        vendor1.setName("Michael");

        VendorDTO returnDTO = new VendorDTO();
        returnDTO.setName(vendor1.getName());
        returnDTO.setVendorUrl(VendorController.BASE_URL + "/1");

        when(vendorService.saveVendorByDTO(anyLong(), any(VendorDTO.class))).thenReturn(returnDTO);

        mockMvc.perform(put(VendorController.BASE_URL + "/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(vendor1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Michael")))
                .andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/1")));
    }

    @Test
    void patchVendor() throws Exception {
        VendorDTO vendor1 = new VendorDTO();
        vendor1.setName("Michael");

        VendorDTO returnDTO = new VendorDTO();
        returnDTO.setName(vendor1.getName());
        returnDTO.setVendorUrl(VendorController.BASE_URL + "/1");

        when(vendorService.patchVendor(anyLong(), any(VendorDTO.class))).thenReturn(returnDTO);

        mockMvc.perform(patch(VendorController.BASE_URL + "/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(vendor1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Michael")))
                .andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/1")));
    }

    @Test
    void deleteVendor() throws Exception {
        mockMvc.perform(delete(VendorController.BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(vendorService).deleteVendorById(anyLong());
    }
}