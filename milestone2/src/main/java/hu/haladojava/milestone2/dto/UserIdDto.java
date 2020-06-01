package hu.haladojava.milestone2.dto;

import javax.validation.constraints.NotNull;

public class UserIdDto {

    @NotNull
    private int userId;
    
    public UserIdDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
