package hu.haladojava.milestone2.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hu.haladojava.milestone2.dto.CreateUserDto;
import hu.haladojava.milestone2.dto.UserDto;
import hu.haladojava.milestone2.entity.UserEntity;
import hu.haladojava.milestone2.exception.ServiceException;
import hu.haladojava.milestone2.mapper.UserMapper;
import hu.haladojava.milestone2.repository.UserRepository;
import hu.haladojava.milestone2.util.Constants;

@Service
public class UserService {

    private UserRepository userRepository;
    private EmailService emailService;
    private UserMapper userMapper;
    
    @Autowired
    public UserService(UserRepository userRepository, EmailService emailService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userMapper = userMapper;
    }
    
    public UserDto createUserEntity(CreateUserDto createUserDto) {
        UserEntity userEntity = this.userMapper.mapCreateUserDtoToEntity(createUserDto);
        
        this.userRepository.save(userEntity);
        
        return this.userMapper.mapUserEntityToDto(userEntity);
    }
    
    public UserDto getUserByUsernameAndPassword(String username, String password) throws ServiceException {
        UserEntity userEntity = this.userRepository.getUserByUsernameAndPassword(username, password);

        if (userEntity != null) {
            return this.userMapper.mapUserEntityToDto(userEntity);            
        } else {
            throw new ServiceException("Not valid parameters for login");
        }
    }
    
    public void uploadDocument(MultipartFile userId, MultipartFile document) throws IOException {
        int convertedUserId = convertUserId(userId);
        this.userRepository.uploadDocument(convertedUserId, document.getBytes());
    }
    
    public int approveDocument(int userId, int adminId) throws ServiceException {
        this.userRepository.approveDocument(userId);
        
        String userEmail = this.userRepository.getEmailByUserId(userId);
        String adminEmail = this.userRepository.getEmailByUserId(adminId);
        
        if (userEmail != null && adminEmail != null) {
            this.emailService.sendEmail(userEmail, Constants.EMAIL_SUBJECT, Constants.STUDENT_EMAIL_TEXT);
            this.emailService.sendEmail(adminEmail, Constants.EMAIL_SUBJECT, Constants.ADMIN_EMAIL_TEXT);            
        } else {
            throw new ServiceException("Couldn't find email for users with id: " + userId + ", " + adminId);
        }
        
        return userId;
    }
    
    public List<UserDto> getAllNotAdminUsers() throws ServiceException {
        List<UserEntity> entityList = this.userRepository.getAllNotAdminUsers();
        
        if (!entityList.isEmpty()) {
            List<UserDto> dtoList = new ArrayList<>();
            for (UserEntity entity : entityList) {
                UserDto dto = this.userMapper.mapUserEntityToDto(entity);
                dtoList.add(dto);
            }
            
            return dtoList;            
        } else {
            throw new ServiceException("Couldn't get any user from database");
        }
        
    }
    
    public void deleteDocument(int userId) {
        this.userRepository.deleteDocument(userId);
    }
    
    public UserDto getUserById(int userId) throws ServiceException {
        UserEntity userEntity = this.userRepository.getUserById(userId);
        
        if (userEntity != null) {
            return this.userMapper.mapUserEntityToDto(userEntity);            
        } else {
            throw new ServiceException("Couldn't find user with id: " + userId);
        }
        
    }
    
    public void refuseDocument(int userId) {
        String userEmail = this.userRepository.getEmailByUserId(userId);
        
        this.emailService.sendEmail(userEmail, Constants.NEGATIVE_EMAIL_SUBJECT, Constants.NEGATIVE_EMAIL_TEXT);
    }
    
    private int convertUserId(MultipartFile userId) throws IOException {
        String value = new String(userId.getBytes());
        
        return Integer.parseInt(value);
    }
}
