package com.example;

public class CalcTest {

    @Test
    public void Test(){
        System.out.println("First Junit");
    }

    @Test
    public void testAdd() {
        Calc calc = new Calc();
        int result = calc.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5"); // message shown if the test fails
    }

    @Test
    public void testDivide() {
        Calc calc = new Calc();
        int result = calc.divide(10, 2);
        assertEquals(5, result, "10 / 2 should equal 5");
    }

    @Test
    public void testDivideByZero() {
        Calc calc = new Calc();
        try {
            calc.divide(5, 0);
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }
}
