package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup(){
        this.calculator = new Calculator();
    }

    @Test
    void sumTest() {
        double sum = calculator.sum(1.0, 2.5);
        assertEquals(3.5, sum);
    }

    @Test
    public void numbersNullSumTest() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            double sum = calculator.sum(1.0, null);
        });

        Assertions.assertEquals("Número 1 e número 2 são obrigatórios.", thrown.getMessage());
    }

    @Test
    void subTest() {
        double sub = calculator.sub(2.5, 1.0);
        assertEquals(1.5, sub);
    }

    @Test
    void divideTest() {
        double div = calculator.divide(9.0, 3.0);
        assertEquals(3.0, div);
    }

    @Test
    public void divisionByZeroTest() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            double sum = calculator.divide(1.0, 0.0);
        });

        Assertions.assertEquals("Divisão por zero não é permitido.", thrown.getMessage());
    }

    @Test
    void factorialTest() {
        double factorial = calculator.factorial(3);
        assertEquals(6, factorial);
    }

    @Test
    void integerToBinaryTest() {
        int binary = calculator.integerToBinary(5);
        assertEquals(101, binary);
    }

    @Test
    void integerToHexadecimalTest() {
        String hex = calculator.integerToHexadecimal(170);
        assertEquals("AA", hex);
    }

    @Test
    void calculeDayBetweenDateTest() {
         LocalDate date1 = LocalDate.of(2020, 3, 15);
         LocalDate date2 = LocalDate.of(2020, 3, 29);
         int dias = calculator.calculeDayBetweenDate(date1, date2);
         assertEquals(14, dias);
    }
}
