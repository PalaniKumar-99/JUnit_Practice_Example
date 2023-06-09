package com.example.PropertyManagement.controller;

import com.example.PropertyManagement.model.CalculatorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    //http://localhost:8080/api/calculator/add?a=4&b=6
    @GetMapping("/add")
    public int add(@RequestParam("a")  int a,@RequestParam("b") int b) {
        return a+b;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public int subtract(@PathVariable int num1, @PathVariable int num2) {
        int result = 0;
        if(num1>num2) {
            result = num1-num2;
        } else {
            result = num2-num1;
        }
        return result;
    }

    @PostMapping("/multiply")
    public Double multiply(@RequestBody CalculatorDTO calculatorDTO) {
        Double result = null;
        result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3();
        return result;
    }
}
