package com.example.PropertyManagement.service;

import com.example.PropertyManagement.binding.PropertyEntity;
import com.example.PropertyManagement.controller.repository.PropertyRepository;
import com.example.PropertyManagement.converter.PropertyConverter;
import com.example.PropertyManagement.exception.BusinessException;
import com.example.PropertyManagement.model.PropertyDTO;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyRepository repository;

    @Autowired
    private PropertyConverter converter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = converter.convertDTOtoEntity(propertyDTO);

        PropertyEntity property = repository.save(propertyEntity);

        PropertyDTO dto = converter.convertEntityToDTO(property);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> entity = repository.findAll();
        List<PropertyDTO> list = new ArrayList<>();
        for(PropertyEntity propertyEntity : entity) {
            PropertyDTO dto = converter.convertEntityToDTO(propertyEntity);
            list.add(dto);
        }
        return list;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Integer propertyId) {
        Optional<PropertyEntity> details = repository.findById(propertyId);
        PropertyDTO dto = null;
        if(details.isPresent()) {
            PropertyEntity propertyEntity = details.get();
            propertyEntity.setPropertyName(propertyDTO.getPropertyName());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            PropertyEntity updatedDetails = repository.save(propertyEntity);
            dto = converter.convertEntityToDTO(updatedDetails);
        }
        return dto;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Integer id) throws BusinessException {
        Optional<PropertyEntity> details = repository.findById(id);
        PropertyDTO dto = null;
        if(details.isPresent()) {
            PropertyEntity propertyEntity = details.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            PropertyEntity updatedDetails = repository.save(propertyEntity);
            dto = converter.convertEntityToDTO(updatedDetails);
        } else {
            throw new BusinessException("No Property found");
        }
        return dto;
    }

    @Override
    public void deleteProperty(Integer id) {
        repository.deleteById(id);;
    }
}
