package hu.java.milestone.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.java.milestone.model.User;

@RestController
public class MainController {
    
    private User user = new User("username", "password", "email");
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView getMainPage(HttpSession session) {
        
        session.setAttribute("user", user);
        ModelAndView mav = new ModelAndView();
        
        
        mav.setViewName("main.html");
        mav.addObject("kenyer", "kenyer");
        
        return mav;
    }
}
