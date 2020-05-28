package hu.haladojava.milestone2.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDto {
   
    @NotNull
    private int id;
    
    @NotNull
    private String username;
    
    @NotNull
    @Email
    private String email;
    
    @NotNull
    private String password;
    
    @NotNull
    private boolean isAdmin;
    
    private boolean documentIsApprovedByUser;
    
    private boolean documentIsApprovedByAdmin;
    
    private byte[] document;
    
    public UserDto() {
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

    public boolean getIsAdmin() {
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

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }
}
