package com.example.PropertyManagement.controller;

import com.example.PropertyManagement.model.CalculatorDTO;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks //It will give memory to the calculator controller
    private CalculatorController calculatorController;

    static int num1;
    static int num2;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All method called");
        num1 = 8;
        num2 = 5;
    }

    @BeforeEach
    void init(){
    System.out.println("Before Each method called");
    }

    @AfterEach
    void destroy() {
        System.out.println("After Each Method");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All Method");
        num1 = 0;
        num2 = 0;
    }
    @Test
    @DisplayName("Test Addition success scenario")
    @Disabled
    void testAddFunction() {
        int result = calculatorController.add(num1, num2);
        //Expected is 13
        //Always Perform Assertion
        assertEquals(13, result);
    }

    @Test
    @DisplayName("Test Addition Failure scenario")
    @Disabled
    void testAdd_Failure() {
        int result = calculatorController.add(num1, num2);
        //Expected is 13
        //Always Perform Assertion
        Assertions.assertNotEquals(10, result);
    }

    @Test
    @DisplayName("Test Subtraction Success scenario")
    public void subtractTest() {
        int result = calculatorController.subtract(num1, num2);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Test Subtraction Success scenario")
    public void subtract_Test() {
        int result = calculatorController.subtract(num1, num2+6);
        Assertions.assertNotEquals(4, result);
    }

    @Test
    @DisplayName("Test multiplication Success scenario")
    void multiplyTest() {
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNum1(2.0);
        calculatorDTO.setNum2(3.9);
        calculatorDTO.setNum3(4.3);
        Double result = calculatorController.multiply(calculatorDTO);
        assertEquals(33.54, result);
    }
}
