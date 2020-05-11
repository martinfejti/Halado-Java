package hu.java.milestone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.java.milestone.service.AdminService;
import hu.java.milestone.service.UserService;

@Controller
public class MainController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping(value="/")
    public ModelAndView getMainPage() {
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("main.html");
        
        return mav;
    }
    
}
