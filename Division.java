package com.netcracker.gurev.calculator;


public class Division extends Sum {
    @Override
    public void setSecond(double input) {
        if(input != 0) {
            super.setSecond(input);
        }
    }

    @Override
    public double result() {
        return arg1/arg2;
    }
}
