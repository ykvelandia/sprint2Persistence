package com.classMongo.bookings.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document (collection = "users_collection")
public class Users  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String username;
    private String email;
    private String cellphone;
    private LocalDate birthDate;
    private LocalDateTime creation;
    private LocalDateTime update;

    public Users() {
    }

    public Users(String username, String email, String cellphone, LocalDate birthDate) {
        this.username = username;
        this.email = email;
        this.cellphone = cellphone;
        this.birthDate = birthDate;
        this.creation = LocalDateTime.now();
        this.update = null;
    }

    public String getId() {
        return id;
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

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }

    public LocalDateTime getUpdate() {
        return update;
    }

    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }

    public void updateUsers(Users users) {
        setUsername(users.getUsername());
        setEmail(users.getEmail());
        setCellphone(users.getCellphone());
        setBirthDate(users.getBirthDate());
        this.update = LocalDateTime.now();

    }
}
