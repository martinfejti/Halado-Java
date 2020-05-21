package hu.java.milestone.mapper;

import org.mapstruct.Mapper;

import hu.java.milestone.dto.UserDto;
import hu.java.milestone.entity.UserEntity;

@Mapper
public abstract class UserMapper {

    public abstract UserDto mapUserEntityToDto(UserEntity userEntity);
    
    public abstract UserEntity mapUserDtoToEntity(UserDto userDto);
}
