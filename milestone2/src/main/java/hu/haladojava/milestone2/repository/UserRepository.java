package hu.haladojava.milestone2.repository;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.haladojava.milestone2.entity.UserEntity;

@Repository
@Transactional
public class UserRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public UserRepository() {
    }
    
    public UserEntity createUserEntity(UserEntity userEntity) {
        this.entityManager.persist(userEntity);
        
        return userEntity;
    }
    
    public UserEntity getUserByUsernameAndPassword(String username, String password) {
        UserEntity result;
        
        TypedQuery<UserEntity> query = this.entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", UserEntity.class);
        query.setParameter("password", password);
        query.setParameter("username", username);
        
        result = query.getSingleResult();
        
        return result;
    }
    
    public void uploadDocument(int userId, File file) {
        Query query = this.entityManager.createQuery("UPDATE User u SET u.document = :file, u.documentIsApprovedByUser = TRUE WHERE u.id = :userId");
        query.setParameter("userId", userId);
        query.setParameter("file", file);
        query.executeUpdate();
    }
    
    public int approveDocument(int userId) {
        Query query = this.entityManager.createQuery("UPDATE User u SET u.documentIsApprovedByAdmin = TRUE WHERE u.id = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
        
        return userId;
    }
    
    public String getUserEmailById(int userId) {
        String result;
        
        TypedQuery<String> query = this.entityManager.createQuery("SELECT u.email FROM User u WHERE u.id = :userId", String.class);
        query.setParameter("userId", userId);
        result = query.getSingleResult();
        
        return result;
    }
}
