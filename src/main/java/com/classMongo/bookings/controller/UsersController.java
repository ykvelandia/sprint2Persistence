package com.classMongo.bookings.controller;

import com.classMongo.bookings.dto.users.UsersDto;
import com.classMongo.bookings.dto.users.UsersResponseDto;
import com.classMongo.bookings.service.users.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("v1/users")
public class UsersController {

    private final UsersService usersService;


    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping
    public ResponseEntity<List<UsersResponseDto>> getAllUsers(){
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<UsersResponseDto>findUsersById(@PathVariable String id){
        try{
            return new ResponseEntity<>(usersService.findUsersById(id), HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity("The user " + id + "doesn´t in the data base", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<UsersResponseDto> createUser (@RequestBody UsersDto usersDto){
        return new ResponseEntity<>(usersService.createUsers(usersDto),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable String id, @RequestBody UsersDto userDto){
        try {
            Boolean isUpdated = usersService.updateUsers(id, userDto);
            if (isUpdated){
                return new ResponseEntity("The user updated ok", HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

        }catch (NoSuchElementException e){
            return new ResponseEntity("The user " + id + " doesn't in the data base", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id){
        return new ResponseEntity<>(usersService.deleteUsers(id), HttpStatus.OK);
    }

}
