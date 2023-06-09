package com.example.PropertyManagement.converter;

import com.example.PropertyManagement.binding.PropertyEntity;
import com.example.PropertyManagement.model.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setPropertyName(propertyDTO.getPropertyName());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        propertyEntity.setPrice(propertyDTO.getPrice());
        return  propertyEntity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity entity) {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setAddress(entity.getAddress());
        dto.setPropertyName(entity.getPropertyName());
        dto.setOwnerName(entity.getOwnerName());
        dto.setOwnerEmail(entity.getOwnerEmail());
        dto.setPrice(entity.getPrice());
        return  dto;
    }
}
