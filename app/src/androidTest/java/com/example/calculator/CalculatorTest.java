package com.example.calculator;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by takafumi.nanao on 8/14/15.
 */
@RunWith(AndroidJUnit4.class)
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        // 毎回同じ事を書くのが面倒なものは、
        // setUpで書くと楽できます
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        // 念のため毎回空っぽにします
        calculator = null;
    }

    @Test
    public void testSetValue() throws Exception {
        calculator.setValue(3);
        assertThat(calculator.getFirstValue(), is(3));

        calculator.setValue(9);
        assertThat(calculator.getFirstValue(), is(39));

        calculator.setValue(4);
        // 3,9,4と入力したら394が計算対象になる
        assertThat(calculator.getFirstValue(), is(394));
    }

    @Test
    public void testSetOperation() throws Exception {
        calculator.setValue(3);
        calculator.setOperation(Calculator.Operation.PLUS);

        // 数字のあとに演算子を入れると演算子が記憶される
        assertThat(calculator.getOperation(), is(Calculator.Operation.PLUS));
    }

    @Test
    public void testCalculate() throws Exception {
        calculator.setValue(3);
        calculator.setOperation(Calculator.Operation.PLUS);
        calculator.setValue(7);
        int result = calculator.calculate();

        // 3たす7は10になる
        assertThat(result, is(10));
    }

    @Test
    public void testClear() throws Exception {
        calculator.setValue(1);
        calculator.setOperation(Calculator.Operation.PLUS);
        calculator.setValue(7);
        calculator.clear();

        // "clear()メソッドで各フィールドは0になる"
        assertThat(calculator.getFirstValue(), is(0));
        assertThat(calculator.getSecondValue(), is(0));
        assertThat(calculator.getOperation(), is(Calculator.Operation.NONE));
    }

    // 0-9以外の数字は例外処理
    @Test(expected = InvalidParameterException.class)
    public void testSetValueInvalidArgumentMinus() throws Exception {
        calculator.setValue(-3);
    }

    @Test(expected = InvalidParameterException.class)
    public void testSetValueInvalidArgumentTooLarge() throws Exception {
        calculator.setValue(324);
    }
}