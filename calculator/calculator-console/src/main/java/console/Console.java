package console;

import java.util.Scanner;

import calculator.Calculator;

public class Console {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Which operator do you want to use? (+,-,*,/)");
        String operator = sc.next(); //asszem a next csak egy karakter
        
        System.out.println("Give the first operand!");
        double fistOperand = sc.nextDouble();
        
        System.out.println("Give the second operand!");
        double secondOperand = sc.nextDouble();
        
        double result = calculator.calculate(operator, fistOperand, secondOperand);
        System.out.println("The result is: " + result);

        sc.close();
    }

}
