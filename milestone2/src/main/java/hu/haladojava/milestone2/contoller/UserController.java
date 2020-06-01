package hu.haladojava.milestone2.contoller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

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
import hu.haladojava.milestone2.dto.UserIdDto;
import hu.haladojava.milestone2.exception.ServiceException;
import hu.haladojava.milestone2.service.UserService;

@CrossOrigin
@RestController
public class UserController {
    
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/login")
    public UserDto getUserByUsernameAndPassword(@RequestBody @Valid LoginDto loginDto) throws Exception {
        return this.userService.getUserByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
    }
    
    @PostMapping("/register")
    public UserDto createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        return this.userService.createUserEntity(createUserDto);
    }
    
    @PostMapping("/uploadDocument")
    public void uploadDocument(@RequestParam("document") MultipartFile document, @RequestParam("userId") MultipartFile userId) throws IOException {
        this.userService.uploadDocument(userId, document);
    }
    
    @PutMapping("/approveDocument")
    public int approveDocument(@RequestBody @Valid ApproveDocumentDto approveDocumentDto) throws ServiceException {
        return this.userService.approveDocument(approveDocumentDto.getUserId(), approveDocumentDto.getAdminId());
    }
    
    @GetMapping("/getAllNotAdminUsers")
    public List<UserDto> getAllNotAdminUsers() throws ServiceException {
        return this.userService.getAllNotAdminUsers();
    }
    
    @PutMapping("/deleteDocument")
    public void deleteDocument(@RequestBody @Valid UserIdDto userIdDto) {
        this.userService.deleteDocument(userIdDto.getUserId());
    }
    
    @PostMapping("/getUserById")
    public UserDto getUserById(@RequestBody @Valid UserIdDto userIdDto) throws ServiceException {
        return this.userService.getUserById(userIdDto.getUserId());
    }
    
    @PostMapping("/refuseDocument")
    public void refuseDocument(@RequestBody @Valid UserIdDto userIdDto) {
        this.userService.refuseDocument(userIdDto.getUserId());
    }
}
