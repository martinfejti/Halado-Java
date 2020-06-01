package hu.haladojava.milestone2.dto;

import javax.validation.constraints.NotNull;

public class ApproveDocumentDto {

    @NotNull
    private int userId;
    
    @NotNull
    private int adminId;
    
    public ApproveDocumentDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
