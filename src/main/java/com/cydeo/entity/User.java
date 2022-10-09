package com.cydeo.entity;

import com.cydeo.enums.Gender;

import java.time.LocalDateTime;

public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String passWord;
    private boolean enabled;
    private Gender Gender;
    private Role role;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime,
                Long lastUpdateUserId, String firstName, String lastName, String userName, String phone,
                String passWord, boolean enabled, Gender gender, Role role) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phone = phone;
        this.passWord = passWord;
        this.enabled = enabled;
        this.Gender = gender;
        this.role = role;
    }
}
