package com.apispring.api.dto;

import com.apispring.api.models.Account;
import com.apispring.api.models.User;
import lombok.Data;

@Data
public class UserDto {
    private Account account;
    private User user;

    public UserDto(Account account, User user) {
        this.account = account;
        this.user = user;
    }
}
