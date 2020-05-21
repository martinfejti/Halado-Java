package hu.java.milestone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.java.milestone.dto.UserDto;
import hu.java.milestone.service.UserService;

@CrossOrigin
@RestController
public class UserController {

//        @Autowired
//        private UserService userService;
//        
//        @RequestMapping(value="/uploadDocument", method=RequestMethod.GET)
//        public ModelAndView uploadDocument(
//                @RequestParam File fileToUpload,
//                HttpSession session
//                ) {
//            User user = (User)session.getAttribute("user");
//            ModelAndView mav = new ModelAndView();
//            System.out.println(fileToUpload.getName());
//            this.userService.uploadDocument(user, fileToUpload);
//            mav.setViewName("user.html");
//            
//            return mav;
//        }
//        
//        @RequestMapping(value="/showUser", method=RequestMethod.GET)
//        public ModelAndView showUser(HttpSession session) {
//            User user = (User)session.getAttribute("user");
//            ModelAndView mav = new ModelAndView();
//            
//            mav.setViewName("admin.html");
//            System.out.println("SHOW USer");
//            System.out.println(user.getUsername());
//            mav.addObject("username", user.getUsername());
//            mav.addObject("email", user.getEmail());
//            mav.addObject("password", user.getPassword());
//            mav.addObject("file", String.valueOf(user.getDocument()));
//            mav.addObject("henlo", "henlo");
//            
//            return mav;
//        }
//        
//        @GetMapping(value="/user.html")
//        public ModelAndView showUserPage() {
//            ModelAndView mav = new ModelAndView();
//            
//            mav.setViewName("user");
//            
//            return mav;
//        }
    
    @Autowired
    private UserService userService;
    
    public UserController() {
    }
    
    @GetMapping("/login")
    public UserDto getUserByUsernameAndPassword(String username, String password) {
        UserDto userDto = this.userService.getUserByUsernameAndPassword(username, password);
        
        return userDto;
    }
    
    @PostMapping("/register")
    public UserDto createUser(UserDto userDto) {
        return this.userService.createUserEntity(userDto);
    }
}
