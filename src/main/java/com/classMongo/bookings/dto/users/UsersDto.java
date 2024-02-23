package com.classMongo.bookings.dto.users;

import java.time.LocalDate;

public class UsersDto {
    private String username;
    private String email;
    private String cellphone;
    private LocalDate birthDate;

    public UsersDto(String username, String email, String cellphone, LocalDate birthDate) {
        this.username = username;
        this.email = email;
        this.cellphone = cellphone;
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
