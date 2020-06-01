package hu.haladojava.milestone2.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hu.haladojava.milestone2.entity.UserEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository <UserEntity, Integer> {
    
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    public UserEntity getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    
    @Modifying
    @Query("UPDATE User u SET u.document = :file, u.documentIsApprovedByUser = TRUE WHERE u.id = :userId")
    public void uploadDocument(@Param("userId") int userId, @Param("file") byte[] file);
    
    @Modifying
    @Query("UPDATE User u SET u.documentIsApprovedByAdmin = TRUE WHERE u.id = :userId")
    public void approveDocument(@Param("userId") int userId);
    
    @Query("SELECT u.email FROM User u WHERE u.id = :userId")
    public String getEmailByUserId(@Param("userId") int userId);
    
    @Query("SELECT u FROM User u WHERE u.isAdmin = FALSE")
    public List<UserEntity> getAllNotAdminUsers();
    
    @Modifying
    @Query("UPDATE User u SET u.document = NULL, u.documentIsApprovedByUser = FALSE, u.documentIsApprovedByAdmin = FALSE WHERE u.id = :userId")
    public void deleteDocument(@Param("userId") int userId);
    
    @Query("SELECT u FROM User u WHERE u.id = :userId")
    public UserEntity getUserById(@Param("userId") int userId);
    
}
