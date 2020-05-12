package hu.java.milestone.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.java.milestone.model.Document;
import hu.java.milestone.model.User;

@Service
public class UserService {
    
    @Autowired
    private User user;
    
    public User registerUser(String username, String password, String email) {
        user = new User(username, password, email);
        System.out.println("User létrehozva " + user.getUsername() + " néven.");
        
        return user;
    }
    
    public void uploadDocument(User user, File file) {
        Document document = new Document(file);
        System.out.println("user receive document: " + user.getUsername());
        user.setDocument(document);
    }
    
    public User getUser() {
        return this.user;
    }
}
