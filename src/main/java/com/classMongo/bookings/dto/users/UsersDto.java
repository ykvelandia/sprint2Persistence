package com.classMongo.bookings.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private String firstName;
    private String lastName     ;
    private String email;
    private LocalDate birthDate;
    private String password;
    private LocalDate userRegistration;

    public UsersDto(String firstName, String lastName, LocalDate birthDate,String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }


    public UsersDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
