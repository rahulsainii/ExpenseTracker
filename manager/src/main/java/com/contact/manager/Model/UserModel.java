package com.contact.manager.Model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModel {

    @NotBlank(message="Name can't be null")
    private String name;

    @NotNull(message="email should not be null")
    @Email(message="enter a valid email")
    private String email;

    @NotNull(message="password can't be empty")
    @Size(min=5,message="minimum password length should be 5 charchters")
    private String password;
    private Long age =0L;
}
