package hu.haladojava.milestone2.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.haladojava.milestone2.dto.CreateUserDto;
import hu.haladojava.milestone2.dto.UserDto;
import hu.haladojava.milestone2.entity.UserEntity;
import hu.haladojava.milestone2.mapper.UserMapper;
import hu.haladojava.milestone2.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
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
    
    public String uploadDocument(int userId) {
        File file = new File("test.txt");
        
        this.userRepository.uploadDocument(userId, file);
        
        return file.getName();
    }
    
    public int approveDocument(int userId) {
        return this.userRepository.approveDocument(userId);
    }
}
