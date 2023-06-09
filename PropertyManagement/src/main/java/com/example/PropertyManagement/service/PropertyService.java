package com.example.PropertyManagement.service;

import com.example.PropertyManagement.binding.PropertyEntity;
import com.example.PropertyManagement.exception.BusinessException;
import com.example.PropertyManagement.model.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Integer propertyId);
    PropertyDTO updateDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Integer id) throws BusinessException;
    void deleteProperty(Integer id);
}
