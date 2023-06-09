package com.example.PropertyManagement.exception;

import lombok.Data;

@Data
public class BusinessException extends  Exception{
    private String message;
    public BusinessException(){};

    public BusinessException(String message){
        this.message=message;
    }
}
