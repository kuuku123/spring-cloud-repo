package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestUser {

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email can not be less than 2 characters")
    private String email;

    @NotNull(message = "name cannot be null")
    @Size(min = 2, message = "name can not be less than 2 characters")
    private String name;

    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password must be equal or greater than 8 characters")
    private String pwd;
}
