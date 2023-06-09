package com.example.PropertyManagement.service;

import com.example.PropertyManagement.binding.PropertyEntity;
import com.example.PropertyManagement.controller.repository.PropertyRepository;
import com.example.PropertyManagement.converter.PropertyConverter;
import com.example.PropertyManagement.exception.BusinessException;
import com.example.PropertyManagement.model.PropertyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceImplTest {

    @InjectMocks
    private PropertyServiceImpl propertyService;

    @Mock
    private PropertyConverter propertyConverter;

    @Mock
    private PropertyRepository propertyRepository;

    @Test
    @DisplayName("Test Success Scenario for saveProperty")
    void testSaveProperty() {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setPropertyName("2BHK");
        propertyDTO.setPrice(1300000.0);

        PropertyEntity entity = new PropertyEntity();
        entity.setOwnerName("Palani");
        entity.setPropertyName("2BHK");

        PropertyEntity savedEntity = new PropertyEntity();
        savedEntity.setId(1);
        savedEntity.setOwnerName("Palani");
        savedEntity.setPropertyName("2BHK");

        PropertyDTO savedDto = new PropertyDTO();
        savedDto.setId(1);
        savedDto.setOwnerName("Palani");
        Mockito.when(propertyConverter.convertDTOtoEntity(Mockito.any())).thenReturn(entity);
        Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(savedEntity);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDto);
        PropertyDTO result = propertyService.saveProperty(propertyDTO);
        Assertions.assertEquals(savedDto.getId(), result.getId());
    }

    @Test
    @DisplayName("Test Success case for getallproperty")
    void testGetAllProperty() {
        List<PropertyEntity> list = new ArrayList<>();
        PropertyEntity entity = new PropertyEntity();
        entity.setId(1);
        entity.setPrice(30000.0);
        list.add(entity);

        PropertyDTO savedDto = new PropertyDTO();
        savedDto.setId(1);
        savedDto.setOwnerName("Palani");

        Mockito.when(propertyRepository.findAll()).thenReturn(list);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDto);
        List<PropertyDTO> propertyDTOS = propertyService.getAllProperties();

        Assertions.assertEquals(1, propertyDTOS.size());
    }

    @Test
    @DisplayName("Test Success Scenario for updateProperty")
    void testUpdateProperty() {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(1);
        dto.setOwnerName("Palani");

        PropertyEntity propertyEntity= new PropertyEntity();
        propertyEntity.setId(1);
        propertyEntity.setPrice(90000.0);
        propertyEntity.setPropertyName("1BHK");
        propertyEntity.setAddress("Hyderabad");
        propertyEntity.setDescription("New");
        propertyEntity.setOwnerName("Uday");
        propertyEntity.setOwnerEmail("uday@gmail.com");

        Mockito.when(propertyRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(propertyEntity));
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(dto);
        PropertyDTO result = propertyService.updateProperty(dto, 1);

        Assertions.assertEquals(dto.getId(), result.getId());
    }

    @Test
    @DisplayName("Test Success Scenario for updatePropertyDescription")
    void testUpdateDescription_success() throws BusinessException {
        PropertyDTO savedDto = new PropertyDTO();
        savedDto.setDescription("Updated Description");
        savedDto.setPrice(90000.0);

        PropertyEntity propertyEntity= new PropertyEntity();
        propertyEntity.setId(1);
        propertyEntity.setPrice(90000.0);
        propertyEntity.setPropertyName("1BHK");
        propertyEntity.setAddress("Hyderabad");
        propertyEntity.setDescription("Updated Description");
        propertyEntity.setOwnerName("Uday");
        propertyEntity.setOwnerEmail("uday@gmail.com");

        Mockito.when(propertyRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(propertyEntity));
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDto);

        PropertyDTO result = propertyService.updateDescription(savedDto, 1);
        Assertions.assertEquals(savedDto.getPrice(), result.getPrice());
        Assertions.assertEquals(savedDto.getDescription(), result.getDescription());
    }


    @Test
    @DisplayName("Test Success Scenario for updatePropertyDescription")
    void testUpdateDescription_failure() throws BusinessException {
        PropertyDTO savedDto = new PropertyDTO();
        savedDto.setDescription("Updated Description");
        savedDto.setPrice(90000.0);

        Mockito.when(propertyRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        BusinessException businessException = Assertions.assertThrows(BusinessException.class, () ->{
            PropertyDTO result = propertyService.updateDescription(savedDto, 1);
        });
        Assertions.assertEquals("No Property found", businessException.getMessage());
    }
}
