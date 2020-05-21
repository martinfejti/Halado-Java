package hu.java.milestone.entity;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="User")
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="is_admin")
    private boolean isAdmin;
    
    @Column(name="document_is_approved_by_user")
    private boolean documentIsApprovedByUser;
    
    @Column(name="document_is_approved_by_admin")
    private boolean documentIsApprovedByAdmin;
    
    @Column(name="document")
    private File document;
    
    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isDocumentIsApprovedByUser() {
        return documentIsApprovedByUser;
    }

    public void setDocumentIsApprovedByUser(boolean documentIsApprovedByUser) {
        this.documentIsApprovedByUser = documentIsApprovedByUser;
    }

    public boolean isDocumentIsApprovedByAdmin() {
        return documentIsApprovedByAdmin;
    }

    public void setDocumentIsApprovedByAdmin(boolean documentIsApprovedByAdmin) {
        this.documentIsApprovedByAdmin = documentIsApprovedByAdmin;
    }

    public File getDocument() {
        return document;
    }

    public void setDocument(File document) {
        this.document = document;
    }
}
