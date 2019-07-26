package com.netcracker.gurev.calculator;

import java.util.Scanner;

public class Polinom extends Sum {
    protected int size;
    protected double[] coeficients;
    protected double variable;

    @Override
    public void requestInput() {
        System.out.println("Hello!\nPlease enter top power of your polinom");
        Scanner input = new Scanner(System.in);
        this.size = input.nextInt();
        double[] coeficients1 = new double[size];
        this.coeficients = coeficients1;
        System.out.println("please enter coefficients in one string, dividing them by space" +
                "\nif there is no coefficent, type zero");
        String coefs = new String();
        Scanner input2 = new Scanner(System.in);
        coefs = input2.nextLine();
        String delims = "[ ]";
        String[] token = coefs.split(delims);
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < size; i++){
            coeficients[i] = Double.parseDouble(token[i]);
            if(Double.parseDouble(token[i]) > 0) {
                output.append("+" + token[i] + "x^" + i);
            }else if(Double.parseDouble(token[i]) < 0){
                output.append("-" + token[i] + "x^" + i + "+");
            }
        }
        System.out.println("Your polinom is: " + output+ "\nEnter x");
        variable = input.nextDouble();
    }

    @Override
    public void requestInputContinue(double mem) {
        System.out.println("Hello!\nPlease enter top power of your polinom");
        Scanner input = new Scanner(System.in);
        this.size = input.nextInt();
        double[] coeficients1 = new double[size];
        this.coeficients = coeficients1;
        System.out.println("please enter coefficients in one string, dividing them by space" +
                "\nif there is no coefficent, type zero");
        String coefs = new String();
        Scanner input2 = new Scanner(System.in);
        coefs = input2.nextLine();
        String delims = "[ ]";
        String[] token = coefs.split(delims);
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < size; i++){
            coeficients[i] = Double.parseDouble(token[i]);
            if(Double.parseDouble(token[i]) > 0) {
                output.append("+" + token[i] + "x^" + i);
            }else if(Double.parseDouble(token[i]) < 0){
                output.append("-" + token[i] + "x^" + i + "+");
            }
        }
        System.out.println("Your polinom is: " + output+ "\n x is:" + mem);
        variable = mem;
    }

    @Override
    public double result() {
        double res = 0;
        for(int i = 0; i < size; i++){
            res += coeficients[i]*Math.pow(variable, i);
        }
        return res;
    }
}
