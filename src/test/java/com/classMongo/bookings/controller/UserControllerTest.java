package com.classMongo.bookings.controller;
import com.classMongo.bookings.controller.user.UsersController;
import com.classMongo.bookings.dto.users.UsersDto;
import com.classMongo.bookings.dto.users.UsersResponseDto;
import com.classMongo.bookings.service.users.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.assertions.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class UserControllerTest {

    @Mock
    private UsersService userService;

    @InjectMocks
    private UsersController usersController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUser() {
        List<UsersResponseDto> usersList = new ArrayList<>();
        when(userService.getAllUsers()).thenReturn(usersList);
        ResponseEntity<List<UsersResponseDto>> responseEntity = usersController.getAllUser();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(usersList, responseEntity.getBody());
    }
    @Test
    public void testDeleteUser() {
        String userId = "123";
        when(userService.deleteUser(userId)).thenReturn(true);
        ResponseEntity<Boolean> responseEntity = usersController.deleteUser(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody());
        verify(userService, times(1)).deleteUser(userId);
    }
    @Test
    public void testCreateUser() {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        UsersDto userDto = new UsersDto("John", "Doe", "john@example.com", "password");
        UsersResponseDto createdUserResponse = new UsersResponseDto("userId", "John", "Doe",birthDate ,"john@example.com","Pas1");
        when(userService.createUser(any(UsersDto.class))).thenReturn(createdUserResponse);
        ResponseEntity<UsersResponseDto> responseEntity = usersController.createUser(userDto);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdUserResponse, responseEntity.getBody());
        verify(userService, times(1)).createUser(userDto);
    }


}

