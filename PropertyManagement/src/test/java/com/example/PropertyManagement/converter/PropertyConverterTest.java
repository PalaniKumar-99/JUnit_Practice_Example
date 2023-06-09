package com.example.PropertyManagement.converter;

import com.example.PropertyManagement.binding.PropertyEntity;
import com.example.PropertyManagement.model.PropertyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyConverterTest {

    @InjectMocks
    private PropertyConverter propertyConverter;
    @Test
    @DisplayName("Test success scenario for convertDTOtoEntity")
    void testConvertDTOtoEntity() {
        PropertyDTO dto = new PropertyDTO();
        dto.setPropertyName("1BHK");
        dto.setPrice(300000.0);
        PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(dto);
        Assertions.assertEquals(dto.getPrice(), propertyEntity.getPrice());
        Assertions.assertEquals(dto.getPropertyName(),propertyEntity.getPropertyName());
    }

    @Test
    @DisplayName("Test Success Scenario for convertEntityToDTO")
    void testConvertEntityToDTO(){
        PropertyEntity entity = new PropertyEntity();
        entity.setPrice(900000.0);
        entity.setOwnerName("Palani");
        PropertyDTO propertyDTO = propertyConverter.convertEntityToDTO(entity);
        Assertions.assertEquals(entity.getPrice(), propertyDTO.getPrice());
        Assertions.assertEquals(entity.getOwnerName(), propertyDTO.getOwnerName());

    }
}
