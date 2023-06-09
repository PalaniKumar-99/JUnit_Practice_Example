package com.example.PropertyManagement.controller;

import com.example.PropertyManagement.exception.BusinessException;
import com.example.PropertyManagement.model.PropertyDTO;
import com.example.PropertyManagement.service.PropertyService;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController;//Mockito is going to create a proxy object
    //of propertyController and inject it to our PropertyControllerTest class

    @Mock// Mockito will give memory to PropertyService and it will inject this dummy/proxy propertyService object
    // inside the proxy object of the PropertyController
    private PropertyService propertyService;

    @Test
    @DisplayName("Test Success scenario for saving property")
    void testSaveProperty() {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setOwnerName("Palani");
        PropertyDTO savedProperty = new PropertyDTO();
        savedProperty.setId(1);

        //Do not make the actual call to propertyService.saveProperty(propertyDTO) rather return dummy object savedProperty
        Mockito.when(propertyService.saveProperty(propertyDTO)).thenReturn(savedProperty);
        ResponseEntity<PropertyDTO> response = propertyController.saveProperty(propertyDTO);
        Assertions.assertNotNull(response.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Test success scenario for getallproperties")
    void testGetAllProperties() {
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(1);
        propertyDTO.setPropertyName("Dummy object");
        propertyDTOList.add(propertyDTO);

        Mockito.when(propertyService.getAllProperties()).thenReturn(propertyDTOList);

        ResponseEntity<List<PropertyDTO>> allProperties = propertyController.getAllProperties();
        assertEquals(1,allProperties.getBody().size());
        assertEquals(HttpStatus.OK.value(), allProperties.getStatusCodeValue());
    }

    @Test
    @DisplayName("Test success scenario for update description")
    void testUpdateDescription() throws BusinessException {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setDescription("New Description");

        Mockito.when(propertyService.updateDescription(Mockito.any(), Mockito.anyInt())).thenReturn(propertyDTO);
        ResponseEntity<PropertyDTO> propertyDTOResponseEntity = propertyController.updateDescription(propertyDTO, 1);

        assertEquals("New Description", propertyDTOResponseEntity.getBody().getDescription());
        assertEquals(HttpStatus.OK.value(), propertyDTOResponseEntity.getStatusCodeValue());
    }

    @Test
    @DisplayName("Test Success scenario for updateproperty")
    void testUpdateProperty() {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setPropertyName("1BHK");
        propertyDTO.setPrice(200000.0);
        propertyDTO.setDescription("New Property Updated");
        propertyDTO.setOwnerName("Palani");
        propertyDTO.setOwnerEmail("abc@gmail.com");

        Mockito.when(propertyService.updateProperty(Mockito.any(), Mockito.anyInt())).thenReturn(propertyDTO);

        ResponseEntity<PropertyDTO> propertyDTOResponseEntity = propertyController.updateProperty(propertyDTO, 1);
        assertEquals(propertyDTO, propertyDTOResponseEntity.getBody());
        assertEquals(HttpStatus.OK.value(), propertyDTOResponseEntity.getStatusCodeValue());
    }
}
