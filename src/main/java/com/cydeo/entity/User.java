package com.cydeo.entity;

import com.cydeo.enums.Gender;

import java.time.LocalDateTime;

public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String passWord;
    private boolean enabled;
    private Gender Gender;
    private Role role;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime,
                Long lastUpdateUserId, String firstName, String lastName, String emailAddress, String phoneNumber,
                String passWord, boolean enabled, com.cydeo.enums.Gender gender, Role role) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
        this.enabled = enabled;
        Gender = gender;
        this.role = role;
    }
}
