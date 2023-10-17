package com.ozan.myticketingproject.entity;

import com.ozan.myticketingproject.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Data
public class User extends BaseEntity{
    //We did not put @AllArgsConstructor why?
    // If you are extending from a class; Lombok do not create full AllArgsConsturctor (including super) for you
    // That's why you need to create allArgs manually
        private String firstName;
        private String lastName;
        private String userName;
        private String password;
        private boolean enabled;
        private String phone;
        private Role role;
        private Gender gender;

    public User(Long id, LocalDate insertDateTime, Long insertUserId, LocalDate lastUpdateTime, Long lastUpdateUserId, String firstName, String lastName, String userName, String password, boolean enabled, String phone, Role role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }
}
