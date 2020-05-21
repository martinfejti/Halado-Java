package hu.java.milestone.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.java.milestone.dto.UserDto;
import hu.java.milestone.entity.UserEntity;
import hu.java.milestone.mapper.UserMapper;
import hu.java.milestone.repository.UserRepository;

@Service
public class UserService {
    
//    @Autowired
//    private User user;
//    
//    public User registerUser(String username, String password, String email) {
//        user = new User(username, password, email);
//        System.out.println("User létrehozva " + user.getUsername() + " néven.");
//        
//        return user;
//    }
//    
//    public void uploadDocument(User user, File file) {
//        Document document = new Document(file);
//        System.out.println("user receive document: " + user.getUsername());
//        user.setDocument(document);
//    }
//    
//    public User getUser() {
//        return this.user;
//    }
    
    private static final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
    
    @Autowired
    private UserRepository userRepository;
    
    public UserService() {
    }
    
    public UserDto createUserEntity(UserDto userDto) {
        UserEntity userEntity = USER_MAPPER.mapUserDtoToEntity(userDto);
        
        this.userRepository.createUserEntity(userEntity);
        
        return USER_MAPPER.mapUserEntityToDto(userEntity);
    }
    
    public UserDto getUserByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = this.userRepository.getUserByUsernameAndPassword(username, password);
        
        UserDto userDto = USER_MAPPER.mapUserEntityToDto(userEntity);
        return userDto;
    }
}
