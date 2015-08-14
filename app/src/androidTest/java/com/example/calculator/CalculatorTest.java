package com.example.calculator;

import junit.framework.TestCase;

/**
 * Created by takafumi.nanao on 8/14/15.
 */
public class CalculatorTest extends TestCase {

    private Calculator calculator;

    public void setUp() throws Exception {
        super.setUp();

        calculator = new Calculator();
    }

    public void tearDown() throws Exception {
        calculator = null;
    }

    public void testSetValue() throws Exception {
        calculator.setValue(3);
        assertEquals(calculator.getFirstValue(), 3);

        calculator.setValue(9);
        assertEquals(calculator.getFirstValue(), 39);

        calculator.setValue(4);
        assertEquals(calculator.getFirstValue(), 394);
    }

    public void testSetOperation() throws Exception {
        calculator.setValue(3);
        calculator.setOperation(Calculator.Operation.PLUS);

        assertEquals(calculator.getOperation(), Calculator.Operation.PLUS);
    }

    public void testCalculate() throws Exception {
        calculator.setValue(3);
        calculator.setOperation(Calculator.Operation.PLUS);
        calculator.setValue(7);
        int result = calculator.calculate();

        assertEquals(result, 10);
    }

    public void testClear() throws Exception {
        calculator.setValue(1);
        calculator.setOperation(Calculator.Operation.PLUS);
        calculator.setValue(7);
        calculator.clear();

        assertEquals(calculator.getFirstValue(), 0);
        assertEquals(calculator.getSecondValue(), 0);
        assertEquals(calculator.getOperation(), Calculator.Operation.NONE);
    }
}