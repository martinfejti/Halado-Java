package hu.haladojava.milestone2.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.haladojava.milestone2.dto.CreateUserDto;
import hu.haladojava.milestone2.dto.UserDto;
import hu.haladojava.milestone2.entity.UserEntity;
import hu.haladojava.milestone2.mapper.UserMapper;
import hu.haladojava.milestone2.repository.UserRepository;
import hu.haladojava.milestone2.util.Constants;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private UserMapper userMapper;
    
    public UserService() {
    }
    
    public UserDto createUserEntity(CreateUserDto createUserDto) {
        UserEntity userEntity = this.userMapper.mapCreateUserDtoToEntity(createUserDto);
        
        this.userRepository.createUserEntity(userEntity);
        
        return this.userMapper.mapUserEntityToDto(userEntity);
    }
    
    public UserDto getUserByUsernameAndPassword(String username, String password) {
        System.out.println("SER " + username + ", " + password);
        UserEntity userEntity = this.userRepository.getUserByUsernameAndPassword(username, password);
        
        System.out.println(userEntity.getUsername());
        System.out.println(userEntity.getPassword());
        
        return this.userMapper.mapUserEntityToDto(userEntity);
    }
    
    public String uploadDocument(int userId) {
        File file = new File("test.txt");
        
        this.userRepository.uploadDocument(userId, file);
        
        return file.getName();
    }
    
    public int approveDocument(int userId, int adminId) {
        this.userRepository.approveDocument(userId);
        
        String userEmail = this.userRepository.getUserEmailById(userId);
        String adminEmail = this.userRepository.getUserEmailById(adminId);
        
        this.emailService.sendEmail(userEmail, Constants.EMAIL_SUBJECT, Constants.STUDENT_EMAIL_TEXT);
        this.emailService.sendEmail(adminEmail, Constants.EMAIL_SUBJECT, Constants.ADMIN_EMAIL_TEXT);
        
        return userId;
    }
}
