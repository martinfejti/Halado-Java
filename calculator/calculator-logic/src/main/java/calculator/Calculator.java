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
        } else if (operator.equals("/")) {
            result = a / b;
        }
        
        System.out.println("Result: " + result);
        
        return result;
    }
}
