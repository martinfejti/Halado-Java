package hu.haladojava.milestone2.dto;

public class ApproveDocumentDto {

    private int userId;
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
