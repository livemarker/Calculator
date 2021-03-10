package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private static double num1;
    private static double num2;
    private static String character;


    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        calculator.initialize();
        System.out.println("result: ");
        System.out.println(calculator.calculate(num1, num2, character));

    }

    private void initialize() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("put in first num");
        num1 = Double.parseDouble(reader.readLine());
        System.out.println("put in character");
        character = reader.readLine();
        System.out.println("put in second num");
        num2 = Double.parseDouble(reader.readLine());
    }

    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private double multiplication(double num1, double num2) {
        return num1 * num2;
    }

    private double division(double num1, double num2) {
        double result=0;
        try {
             result= num1 / num2;
        } catch (ArithmeticException exception) {
            System.out.println("error division");
        }
        return result;
    }

    private double substraction(double num1, double num2) {
        return num1 - num2;
    }

    private double degree(double num1, double num2) {
        double result = num1;
        for (int i = 1; i < num2; i++) {
            result *= num1;
        }
        return result;
    }                                                        // можно добавить еще возможности реализации

    private double calculate(double num1, double num2, String character) {
        double result;
        switch (character) {
            case "/": {
                result = division(num1, num2);
                break;
            }
            case "*": {
                result = multiplication(num1, num2);
                break;
            }
            case "+": {
                result = sum(num1, num2);
                break;
            }
            case "-": {
                result = substraction(num1, num2);
                break;
            }
            case "^": {
                result = degree(num1, num2);
                break;
            }  // можно добавить еще возможности реализации
            default:
                throw new IllegalStateException("Unexpected value: " + character);
        }
        return result;
    }
}
