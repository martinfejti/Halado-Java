package hu.java.milestone.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.java.milestone.model.Admin;
import hu.java.milestone.model.User;
import hu.java.milestone.service.AdminService;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    private Admin admin = new Admin("username", "password", "email");
    
    @GetMapping(value="/admin.html")
    public ModelAndView showAdminPage() {
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("admin");
        
        return mav;
    }
    
    @GetMapping(value="/approveDocument")
    public ModelAndView approveDocument(HttpSession session) {
        System.out.println("approve admin cont");
        User user = (User)session.getAttribute("user");
        ModelAndView mav = new ModelAndView();
        
        this.adminService.setDocumentApproved(user);
        mav.setViewName("admin");
        
        return mav;
    }
}
