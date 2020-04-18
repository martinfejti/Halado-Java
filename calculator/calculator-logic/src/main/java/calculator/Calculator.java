package calculator;

public class Calculator {
    
    public Calculator() {
    }
    
    public double calculate(String operator, double a, double b) {
        double result = 0;
        
        if (operator.equals("+")) {
            result = a + b;
        } else if (operator.equals("-")) {
            result = a - b;
        } else if (operator.equals("*")) {
            result = a * b;
        } else if (operator.equals("/")) {
            result = a / b;
        }
        
        return result;
    }
}
