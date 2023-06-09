package com.example.PropertyManagement.controller;

import com.example.PropertyManagement.binding.PropertyEntity;
import com.example.PropertyManagement.exception.BusinessException;
import com.example.PropertyManagement.model.PropertyDTO;
import com.example.PropertyManagement.service.PropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        PropertyDTO result = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> properties = propertyService.getAllProperties();
        return new ResponseEntity<List<PropertyDTO>>(properties, HttpStatus.OK);
    }

    @PutMapping("/updateproperty/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Integer id) {
        PropertyDTO updatedProperty = propertyService.updateProperty(propertyDTO, id);
        return new ResponseEntity<>(updatedProperty,HttpStatus.OK);
    }

    @PatchMapping("/updatedescription/{id}")
    public ResponseEntity<PropertyDTO> updateDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Integer id) throws BusinessException {
        PropertyDTO updateDescription = propertyService.updateDescription(propertyDTO, id);
        return new ResponseEntity<PropertyDTO>(updateDescription, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProperty(@PathVariable Integer id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
