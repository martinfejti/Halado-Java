package web.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import calculator.Calculator;

@Controller
public class MainController {

    @Autowired
    private Calculator calculator;
    
    @GetMapping(value="/")
    public ModelAndView getCalculator() {
        ModelAndView mav = new ModelAndView();
        
        // set view name to html
        mav.setViewName("index.html");
        mav.addObject(calculator);
        
        return mav;
    }
    
    @PostMapping(value="/")
    public ModelAndView calculate(
            @RequestParam(required=true) String operator,
            @RequestParam double firstOperand,
            @RequestParam double secondOperand
            ) {
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("index.html");
        mav.addObject("result", String.valueOf(calculator.calculate(operator, firstOperand, secondOperand)));
        
        return mav;
    }
    
}
