package application;

import framework.parta.Before;
import framework.Test;
import framework.TestClass;

import static framework.partb.Asserts.assertEquals;

@TestClass
public class MyTestB {
    Calculator calculator;

    @Before
    public void init() {
        System.out.println("Part B: Without @Inject annotation");
        calculator = new CalculatorImpl();
    }

    @Test
    public void testMethod1() {
        assertEquals(calculator.add(3),3);
        assertEquals(calculator.add(6),9);
    }
    @Test
    public void testMethod2() {
        assertEquals(calculator.add(3),3);
        assertEquals(calculator.subtract(6),-1);
    }

}
