package com.example.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CalculatorDTO {
    private Double num1;
    private Double num2;
    @JsonProperty("num33")// If you want to send the value using the different key(num33 instead of num33)
    // you have to specify the key using this annotation
    private Double num3;
}
