package hu.haladojava.milestone2.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        UserEntity userEntity = this.userRepository.getUserByUsernameAndPassword(username, password);
        
        return this.userMapper.mapUserEntityToDto(userEntity);
    }
    
    public String uploadDocument(int userId, MultipartFile document) {
        this.userRepository.uploadDocument(userId, document);
        
        return document.getName();
    }
    
    public int approveDocument(int userId, int adminId) {
        this.userRepository.approveDocument(userId);
        
        String userEmail = this.userRepository.getUserEmailById(userId);
        String adminEmail = this.userRepository.getUserEmailById(adminId);
        
        this.emailService.sendEmail(userEmail, Constants.EMAIL_SUBJECT, Constants.STUDENT_EMAIL_TEXT);
        this.emailService.sendEmail(adminEmail, Constants.EMAIL_SUBJECT, Constants.ADMIN_EMAIL_TEXT);
        
        return userId;
    }
    
    public List<UserDto> getAllNotAdminUsers() {
        List<UserEntity> entityList = this.userRepository.getAllNotAdminUsers();
        
        List<UserDto> dtoList = new ArrayList<>();
        for (UserEntity entity : entityList) {
            UserDto dto = this.userMapper.mapUserEntityToDto(entity);
            dtoList.add(dto);
        }
        
        return dtoList;
    }
}
