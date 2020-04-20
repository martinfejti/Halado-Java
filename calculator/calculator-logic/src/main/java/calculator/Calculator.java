package calculator;

public class Calculator {
    
    public Calculator() {
    }
    
    public double calculate(String operator, double a, double b) {
        double result = 0;
        System.out.println("Params - operator: " + operator + ", " + a + ", " + b);
        
        if (operator.equals("+")) {
            result = a + b;
        } else if (operator.equals("-")) {
            result = a - b;
        } else if (operator.equals("*")) {
            result = a * b;
        } else if (operator.equals("/") && b != 0) {
            result = a / b;
        } else {
            System.out.println("Unrecognizable operator or division with zero! Method return with 0");
        }
        
        System.out.println("Result: " + result);
        
        return result;
    }
}
