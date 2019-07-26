package com.netcracker.gurev.calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {
    protected double arg1;
    protected double arg2;
    public static double result;

    public void setFirst(double input){
        this.arg1 = input;
    }

    public void setSecond(double input){ this.arg2 = input; }

    public void requestInput() throws InputMismatchException {
        System.out.println("Enter first number");
        Scanner input = new Scanner(System.in);
        this.setFirst(input.nextDouble());
        System.out.println("Enter second number");
        this.setSecond(input.nextDouble());
    }

    public void requestInputContinue(double mem) throws InputMismatchException{
        Scanner input = new Scanner(System.in);
        this.setFirst(mem);
        System.out.println("Enter second number");
        this.setSecond(input.nextDouble());
    }

    public double result(){
        result = arg1 + arg2;
        return arg1 + arg2;
    }
}
