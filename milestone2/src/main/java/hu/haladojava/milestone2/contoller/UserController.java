package hu.haladojava.milestone2.contoller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hu.haladojava.milestone2.dto.ApproveDocumentDto;
import hu.haladojava.milestone2.dto.CreateUserDto;
import hu.haladojava.milestone2.dto.LoginDto;
import hu.haladojava.milestone2.dto.UserDto;
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
        return this.userService.getUserByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
    }
    
    @PostMapping("/register")
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return this.userService.createUserEntity(createUserDto);
    }
    
    @PostMapping("/uploadDocument")
    public String uploadDocument(@RequestParam("document") MultipartFile document, @RequestParam("userId") MultipartFile userId) throws IOException {
        System.out.println(document.getOriginalFilename());
        String value = new String(userId.getBytes());
        System.out.println(value);
        return this.userService.uploadDocument(userId, document);
    }
    
    @PutMapping("/approveDocument")
    public int approveDocument(@RequestBody ApproveDocumentDto approveDocumentDto) {
        return this.userService.approveDocument(approveDocumentDto.getUserId(), approveDocumentDto.getAdminId());
    }
    
    @GetMapping("/getAllNotAdminUsers")
    public List<UserDto> getAllNotAdminUsers() {
        return this.userService.getAllNotAdminUsers();
    }
}
