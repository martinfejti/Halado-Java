import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.Calculator;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    double firstOperand = 5;
    double secondOperand = 5;
    
    @Test
    public void caseAddition() {
        String operator = "+";
        
        assertEquals(firstOperand + secondOperand, calculator.calculate(operator, firstOperand, secondOperand), 0);
    }
    
    @Test
    public void caseSubstraction() {
        String operator = "-";
        
        assertEquals(firstOperand - secondOperand, calculator.calculate(operator, firstOperand, secondOperand), 0);
    }
    
    @Test
    public void caseMultiplication() {
        String operator = "*";
        
        assertEquals(firstOperand * secondOperand, calculator.calculate(operator, firstOperand, secondOperand), 0);
    }
    
    @Test
    public void caseDivision() {
        String operator = "/";
        
        assertEquals(firstOperand / secondOperand, calculator.calculate(operator, firstOperand, secondOperand), 0);
    }
    
    @Test
    public void caseDivisionByZero() {
        String operator = "/";
        
        assertEquals(0, calculator.calculate(operator, firstOperand, 0), 0);
    }
    
    @Test
    public void caseWrongOperator() {
        String operator = "%";
        
        assertEquals(0, calculator.calculate(operator, firstOperand, secondOperand), 0);
    }
}
