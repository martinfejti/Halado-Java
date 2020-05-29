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
        
        if (userEntity.getDocument() != null) {
            userDto.setDocument(new String(userEntity.getDocument()));              
        }

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
    
//    private File convertByteArrayToFile(byte[] byteArray) throws IOException {
//        System.out.println(byteArray);
//        if (byteArray.length > 0 && byteArray != null) {
//            System.out.println("nem üres");
//            File tempFile = File.createTempFile("test", ".txt");
//            FileOutputStream fos = new FileOutputStream(tempFile);
//            fos.write(byteArray);
//            fos.close();
//            
//            return tempFile;
//        } else {
//            System.out.println("üres");
//            File tempFile = File.createTempFile("test", ".txt");
//            return tempFile;
//        }
//        
//    }
}
