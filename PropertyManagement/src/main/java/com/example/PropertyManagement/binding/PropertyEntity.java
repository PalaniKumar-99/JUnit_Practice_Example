package com.example.PropertyManagement.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Data
@Table(name = "PROPERTY_TABLE")
@AllArgsConstructor
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String propertyName;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private double price;
    private String Address;
}
