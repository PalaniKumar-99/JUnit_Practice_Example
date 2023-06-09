package com.example.PropertyManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {
    private Integer id;
    private String propertyName;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private double price;
    private String Address;
}
