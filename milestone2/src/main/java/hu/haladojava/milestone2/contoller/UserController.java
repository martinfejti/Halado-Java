package hu.haladojava.milestone2.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.haladojava.milestone2.dto.CreateUserDto;
import hu.haladojava.milestone2.dto.UserDto;
import hu.haladojava.milestone2.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    public UserController() {
    }
    
    @GetMapping("/login")
    public UserDto getUserByUsernameAndPassword(String username, String password) {
        // annotation on params might be needed
        return this.userService.getUserByUsernameAndPassword(username, password);
    }
    
    @PostMapping("/register")
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return this.userService.createUserEntity(createUserDto);
    }
}
