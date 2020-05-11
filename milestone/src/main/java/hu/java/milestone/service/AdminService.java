package hu.java.milestone.service;

import org.springframework.stereotype.Service;

import hu.java.milestone.model.Admin;
import hu.java.milestone.model.User;

@Service
public class AdminService {

    public void registerAdmin(String username, String password, String email) {
        Admin admin = new Admin(username, password, email);
        System.out.println("admin regisztrálva " + admin.getUsername() + " néven");
    }
    
    public void setDocumentApproved(User user) {
        user.getDocument().setApprovedByAdmin(true);
    }
}
