package com.cydeo.config.dto;

import com.cydeo.entity.Role;
import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String passWord;
    private boolean enabled;
    private Gender Gender;
    private RoleDTO role;


}
