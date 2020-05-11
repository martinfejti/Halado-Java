package hu.java.milestone.service;

import java.io.File;

import org.springframework.stereotype.Service;

import hu.java.milestone.model.Document;
import hu.java.milestone.model.User;

@Service
public class UserService {
    
    public void registerUser(String username, String password, String email) {
        User user = new User(username, password, email);
        System.out.println("User létrehozva " + user.getUsername() + " néven.");
    }
    
    public void uploadDocument(User user, File file) {
        Document document = new Document(file);
        user.setDocument(document);
    }
}
