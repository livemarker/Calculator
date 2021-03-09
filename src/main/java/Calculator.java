package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private static double num1;
    private static double num2;
    private static String character;


    public static void main(String[] args) throws IOException {
      Calculator calculator=new Calculator();
      calculator.initialize();
        System.out.println("result: ");
        System.out.println(calculator.calculate(num1,num2,character));

    }
    private  void initialize() throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("put in first num");
        num1=Double.parseDouble(reader.readLine());
        System.out.println("put in character");
        character= reader.readLine();
        System.out.println("put in second num");
        num2=Double.parseDouble(reader.readLine());
    }
    private double sum(double a, double b){
        return a+b;
    }
    private double multiplication(double a, double b){
        return a*b;
    }
    private double division(double a, double b){
        return a/b;
    }
    private double substraction(double a, double b){
        return a-b;
    }
    private double degree(double a, double b){
        double result=a;
        for (int i = 1; i <b ; i++) {
            result*=a;
        }
        return result;
    }                                                        // можно добавить еще возможности реализации
    private double calculate(double a, double b, String c){
        double result;
        switch (c){
            case "/":{result= division(a, b);break;}
            case "*":{result=multiplication(a, b);break;}
            case "+":{result=sum(a, b);break;}
            case "-":{result=substraction(a, b);break;}
            case "^" :{result=degree(a, b);break;}  // можно добавить еще возможности реализации
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        return result;
    }
}
