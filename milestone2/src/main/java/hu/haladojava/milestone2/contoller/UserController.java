package hu.haladojava.milestone2.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.haladojava.milestone2.dto.ApproveDocumentDto;
import hu.haladojava.milestone2.dto.CreateUserDto;
import hu.haladojava.milestone2.dto.LoginDto;
import hu.haladojava.milestone2.dto.UserDto;
import hu.haladojava.milestone2.dto.UserIdDto;
import hu.haladojava.milestone2.service.UserService;

@CrossOrigin
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    public UserController() {
    }
    
    @PostMapping("/login")
    public UserDto getUserByUsernameAndPassword(@RequestBody LoginDto loginDto) {
        System.out.println("CON " + loginDto.getUsername() + ", " + loginDto.getPassword());
        return this.userService.getUserByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
    }
    
    @PostMapping("/register")
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return this.userService.createUserEntity(createUserDto);
    }
    
    @PutMapping("/uploadDocument")
    public String uploadDocument(@RequestBody UserIdDto userIdDto) {
        return this.userService.uploadDocument(userIdDto.getUserId());
    }
    
    @PutMapping("/approveDocument")
    public int approveDocument(@RequestBody ApproveDocumentDto approveDocumentDto) {
        return this.userService.approveDocument(approveDocumentDto.getUserId(), approveDocumentDto.getAdminId());
    }
}
