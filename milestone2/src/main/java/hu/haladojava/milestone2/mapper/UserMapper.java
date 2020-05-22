package hu.haladojava.milestone2.mapper;

import org.springframework.stereotype.Component;

import hu.haladojava.milestone2.dto.CreateUserDto;
import hu.haladojava.milestone2.dto.UserDto;
import hu.haladojava.milestone2.entity.UserEntity;

@Component
public class UserMapper {

    public UserMapper() {
    }
    
    public UserDto mapUserEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        
        userDto.setId(userEntity.getId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setEmail(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        userDto.setAdmin(userEntity.getIsAdmin());
        userDto.setDocumentIsApprovedByAdmin(userEntity.isDocumentIsApprovedByAdmin());
        userDto.setDocumentIsApprovedByUser(userEntity.isDocumentIsApprovedByUser());
        userDto.setDocument(userEntity.getDocument());
        
        return userDto;
    }
    
    public UserEntity mapCreateUserDtoToEntity(CreateUserDto createUserDto) {
        UserEntity userEntity = new UserEntity();
        
        userEntity.setUsername(createUserDto.getUsername());
        userEntity.setEmail(createUserDto.getEmail());
        userEntity.setPassword(createUserDto.getPassword());
        userEntity.setAdmin(createUserDto.getIsAdmin());
        userEntity.setDocumentIsApprovedByAdmin(false);
        userEntity.setDocumentIsApprovedByUser(false);

        return userEntity;
    }
}
