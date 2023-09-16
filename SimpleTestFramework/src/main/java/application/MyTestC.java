package application;

import framework.parta.Before;
import framework.partc.Inject;
import framework.Test;
import framework.TestClass;

import static framework.partb.Asserts.assertEquals;

@TestClass
public class MyTestC {
    @Inject
    Calculator calculator;

    @Before
    public void init() {
        System.out.println("Part C: With @Inject annotation");
        calculator.reset();
    }

    @Test
    public void testMethod1() {
        assertEquals(calculator.add(3),3);
        assertEquals(calculator.add(4),7);
    }
    @Test
    public void testMethod2() {
        assertEquals(calculator.add(3),3);
        assertEquals(calculator.subtract(6),-1);
    }

}
