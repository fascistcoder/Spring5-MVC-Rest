package com.example.services;

import com.example.api.v1.mapper.VendorMapper;
import com.example.api.v1.model.VendorDTO;
import com.example.controllers.v1.VendorController;
import com.example.domain.Vendor;
import com.example.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/03/22
 */
@Service
public class VendorServiceImpl implements VendorService{

    private VendorMapper vendorMapper;
    private VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository
                .findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl(getvendorUrl(vendor.getId()));
                    return vendorDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorsById(Long id) {
        return vendorRepository.findById(id)
                .map(vendorMapper::vendorToVendorDTO)
                .map(vendorDTO -> {
                    vendorDTO.setVendorUrl(getvendorUrl(id));
                    return vendorDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        return saveAndReturnByDTO(vendorMapper.vendorDTOToVendor(vendorDTO));
    }

    private VendorDTO saveAndReturnByDTO(Vendor vendor){
        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDTO returnDto = vendorMapper.vendorToVendorDTO(savedVendor);

        returnDto.setVendorUrl(getvendorUrl(savedVendor.getId()));

        return returnDto;
    }

    @Override
    public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendor.setId(id);

        return saveAndReturnByDTO(vendor);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id).map(vendor -> {
            if(vendorDTO.getName() != null){
                vendor.setName(vendorDTO.getName());
            }

            VendorDTO returnDto = vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
            returnDto.setVendorUrl(getvendorUrl(id));

            return returnDto;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.deleteById(id);
    }

    private String getvendorUrl(Long id) {
        return VendorController.BASE_URL + "/" +id;
    }
}
