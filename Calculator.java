package com.netcracker.gurev.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Calculator {
    public void calculate() {
        Scanner input = new Scanner(System.in);
        boolean continue1 = false;
        double memorie = 0;
        while (true) {
            System.out.println("Enter operation: + - * / or type polinom" + "\nIf you want to stop, type: EXIT");
            String operator = input.nextLine();

            String className = new String();

            if ("EXIT".equalsIgnoreCase(operator)) {
                System.out.println("Have a nice day\nGood bye!");
                break;
            }

            switch (operator) {
                case "+":
                    className = "com.netcracker.gurev.calculator.Sum";
                    break;
                case "-":
                    className = "com.netcracker.gurev.calculator.Difference";
                    break;
                case "*":
                    className = "com.netcracker.gurev.calculator.Multiplication";
                    break;
                case "/":
                    className = "com.netcracker.gurev.calculator.Division";
                    break;
                case "polinom":
                    className = "com.netcracker.gurev.calculator.Polinom";
                    break;

            }


            try {
                Class var = Class.forName(className);
                Object oper = var.newInstance();
                Sum op = (Sum) oper;
                if (continue1) {
                    op.requestInputContinue(memorie);
                } else {
                    op.requestInput();
                }
                memorie = op.result();
                System.out.println("Your result is: " + op.result() + "\nWould You like to use result as first operand?" +
                        "\nType Y or N");
                String cont = input.nextLine();

                if (cont.equalsIgnoreCase("Y")) {
                    continue1 = true;
                } else if (cont.equalsIgnoreCase("N")) {
                    continue1 = false;
                }


            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex1) {
                System.out.println(ex1.toString() + "\nOoops something is wrong\nPerhaps this version of Calculator does not support " +
                        "this mathematical operation :(");
            } catch (InputMismatchException wrongInput) {
                System.out.println(wrongInput.toString() + "\nYour input should contain only numbers\n" +
                        "Try again, I believe in you");
            }
        }
    }

    public float countServer(String operation){
        String delim = " ";
        String[] tokens = operation.split(delim);
        String operator = tokens[tokens.length - 1];
        float[] arguments = new float[tokens.length - 1];
        for(int i = 0; i < tokens.length - 1; i++){
            arguments[i] = Float.parseFloat(tokens[i]);
        }

        String className = new String();
        switch (operator) {
            case "+":
                className = "com.netcracker.gurev.calculator.Sum";
                break;
            case "-":
                className = "com.netcracker.gurev.calculator.Difference";
                break;
            case "*":
                className = "com.netcracker.gurev.calculator.Multiplication";
                break;
            case "/":
                className = "com.netcracker.gurev.calculator.Division";
                break;
            case "polinom":
                className = "com.netcracker.gurev.calculator.Polinom";
                break;

        }

        float result = 0;
        try {
            Class var = Class.forName(className);
            Object oper = var.newInstance();
            Sum op = (Sum) oper;
            op.setFirst(arguments[0]);
            op.setSecond(arguments[1]);
            result = (float)op.result();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex1) {
            System.out.println(ex1.toString() + "\nOoops something is wrong\nPerhaps this version of Calculator does not support " +
                    "this mathematical operation :(");
        } catch (InputMismatchException wrongInput) {
            System.out.println(wrongInput.toString() + "\nYour input should contain only numbers\n" +
                    "Try again, I believe in you");
        }
        return result;
    }
}
