package com.classMongo.bookings.controller.user;

import com.classMongo.bookings.dto.users.UsersDto;
import com.classMongo.bookings.dto.users.UsersResponseDto;
import com.classMongo.bookings.service.users.UsersService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static com.classMongo.bookings.utils.Constants.ADMIN_ROLE;


@RestController
@RequestMapping("/v1/users")
public class UsersController {

    private final UsersService userService;

    public UsersController(UsersService userService) {
        this.userService = userService;
        //loadSampleUsers();
    }


    public void loadSampleUsers() {
        LocalDate fecha = LocalDate.of(2024, 3, 22);
        UsersDto userEntity = new UsersDto("Ada", " Lovelace", fecha, "ada@mail.com", "passw0rd");
        userService.createUser(userEntity);
        UsersDto adminUserEntity = new UsersDto("Ada", "Admin", fecha, "admin@mail.com", "passw0rd");
        UsersResponseDto userCreated = userService.createUser(adminUserEntity);
        createUserAdmin(new UsersDto("Super", "admin", fecha, "super@mail.com", "123"));
    }
    @GetMapping
    public ResponseEntity<List<UsersResponseDto>> getAllUser(){
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        }catch (Exception e){
            return new ResponseEntity("Error in getAllUsers controller: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <UsersResponseDto> findUserById (@PathVariable String id){
        try{
            return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("the user " + id + " doesn't in the data base.", HttpStatus.NOT_FOUND);
        }
    }
    @RolesAllowed(ADMIN_ROLE)
    @PutMapping("/{idUser}")
    public ResponseEntity<Boolean> updateUser(@PathVariable String idUser,@RequestBody UsersDto userDto) {
        try {
            Boolean isUpdateUser = userService.updateUser(idUser, userDto);
            if (isUpdateUser) {
                return new ResponseEntity("The user is update", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity("the user " + idUser + " doesn't in the data base.", HttpStatus.NOT_FOUND);
        }
    }
    @RolesAllowed(ADMIN_ROLE)
    @PostMapping
    public ResponseEntity<UsersResponseDto> createUser(@RequestBody UsersDto userDto){
        try{
            return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity("An error has occurred while retrieving users", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RolesAllowed(ADMIN_ROLE)
    @PostMapping("/createAdmin")
    public ResponseEntity<UsersResponseDto> createUserAdmin(@RequestBody UsersDto userDto){
        return new ResponseEntity<>(userService.createUserAdmin(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

}