package hu.java.milestone.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.java.milestone.entity.UserEntity;

@Repository
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
}
