package hu.java.milestone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.java.milestone.service.AdminService;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @RequestMapping(value="/registerAdmin", method=RequestMethod.GET)
    public ModelAndView registerAdmin(
            @RequestParam String adminUsername,
            @RequestParam String adminEmail,
            @RequestParam String adminPassword
            ) {
        ModelAndView mav = new ModelAndView();
        System.out.println("Admin Controller");
        this.adminService.registerAdmin(adminUsername, adminPassword, adminEmail);
        
        mav.setViewName("main.html");
        
        return mav;
    }
}
