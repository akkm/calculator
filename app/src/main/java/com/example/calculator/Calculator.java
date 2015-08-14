package com.example.calculator;

import java.security.InvalidParameterException;

/**
 * @author KeishinYokomaku
 */
public class Calculator {
    private int firstValue = 0;
    private int secondValue = 0;
    private Operation operation = Operation.NONE;

    // 数字をセットする
    public void setValue(int value) {
        if (value < 0 || value > 10) {
            throw new InvalidParameterException();
        }

        if (operation == Operation.NONE) {
            firstValue = firstValue * 10 + value; // 連続して数字を入力した時は桁をずらして足す
        } else {
            secondValue = secondValue * 10 + value; // 連続して数字を入力した時は桁をずらして足す
        }
    }

    // 演算子をセットする
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public Operation getOperation() {
        return operation;
    }

    // 計算する
    public int calculate() {
        switch (operation) {
            case PLUS:
                return firstValue + secondValue;
            case SUBTRACTION:
                return firstValue - secondValue;
            case MULTIPLICATION:
                return firstValue * secondValue;
            case DIVISION:
                return firstValue / secondValue;
            default:
                return 0;
        }
    }

    // 最初の状態に戻す
    public void clear() {
        firstValue = 0;
        secondValue = 0;
        operation = Operation.NONE;
    }

    public enum Operation {
        PLUS("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("×"),
        DIVISION("÷"),
        NONE("");
        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
