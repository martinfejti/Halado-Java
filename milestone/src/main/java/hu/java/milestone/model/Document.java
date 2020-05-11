package hu.java.milestone.model;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class Document {

    private File file;
    private boolean approvedByUser;
    private boolean approvedByAdmin;
    
    public Document(File file) {
        this.file = file;
        this.approvedByUser = true;
        this.approvedByAdmin = false;
    }
    
    public Document() {
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isApprovedByUser() {
        return approvedByUser;
    }

    public void setApprovedByUser(boolean approvedByUser) {
        this.approvedByUser = approvedByUser;
    }

    public boolean isApprovedByAdmin() {
        return approvedByAdmin;
    }

    public void setApprovedByAdmin(boolean approvedByAdmin) {
        this.approvedByAdmin = approvedByAdmin;
    }
    
}
