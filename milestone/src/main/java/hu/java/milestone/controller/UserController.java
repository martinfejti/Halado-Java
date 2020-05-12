package hu.java.milestone.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.java.milestone.model.User;
import hu.java.milestone.service.UserService;

@RestController
public class UserController {

        @Autowired
        private UserService userService;
        
        @Autowired
        private User user;
        
        @RequestMapping(value="/registerUser", method=RequestMethod.GET)
        public ModelAndView registerUser(
                @RequestParam String userUsername,
                @RequestParam String userEmail,
                @RequestParam String userPassword   
                ) {
            ModelAndView mav = new ModelAndView();
            System.out.println("User Controller");
            
            user = this.userService.registerUser(userUsername, userEmail, userPassword);
            mav.setViewName("main.html");
            
            return mav;
        }
        
        @RequestMapping(value="/uploadDocument", method=RequestMethod.GET)
        public ModelAndView uploadDocument(
                @RequestParam File fileToUpload
                ) {
            ModelAndView mav = new ModelAndView();
            System.out.println(fileToUpload.getName());
            this.userService.uploadDocument(user, fileToUpload);
            mav.setViewName("user.html");
            
            return mav;
        }
        
        @RequestMapping(value="/showUser", method=RequestMethod.GET)
        public ModelAndView showUser() {
            ModelAndView mav = new ModelAndView();
            System.out.println("SHOW USER");
            mav.setViewName("admin.html");
            mav.addObject("username", String.valueOf(user.getUsername()));
            System.out.println(user.getUsername());
            mav.addObject("email", user.getEmail());
            mav.addObject("password", user.getPassword());
            mav.addObject("file", user.getDocument());
            
            return mav;
        }
}
