package hu.haladojava.milestone2.dto;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class UploadDocumentDto {

    private int userId;
    private File document;
    
    public UploadDocumentDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public File getDocument() {
        return document;
    }

    public void setDocument(File document) {
        this.document = document;
    }
}
