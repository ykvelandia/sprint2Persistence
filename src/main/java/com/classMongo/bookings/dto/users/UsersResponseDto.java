package com.classMongo.bookings.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class UsersResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;

}
