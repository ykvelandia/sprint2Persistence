package com.classMongo.bookings.service;

import com.classMongo.bookings.dto.users.UsersResponseDto;
import com.classMongo.bookings.repository.user.UsersRepository;
import com.classMongo.bookings.service.users.UsersServiceImplements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;

import static com.mongodb.assertions.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersServiceImplements usersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers_NoUsers() {
        when(usersRepository.getAllUsers()).thenReturn(Collections.emptyList());
        List<UsersResponseDto> result = usersService.getAllUsers();
        assertEquals(0, result.size());
        verify(usersRepository, times(1)).getAllUsers();
    }
    @Test
    public void testDeleteUser() {
        String userId = "exampleUserId";
        when(usersRepository.deleteUserById(userId)).thenReturn(true);
        Boolean result = usersService.deleteUser(userId);
        assertTrue(result);
        verify(usersRepository, times(1)).deleteUserById(userId);
    }
    @Test
    public void testDeleteUser_UserDoesNotExist() {
        String userId = "123";
        when(usersRepository.deleteUserById(userId)).thenReturn(false);
        Boolean result = usersService.deleteUser(userId);
        assertFalse(result);
        verify(usersRepository, times(1)).deleteUserById(userId);
    }


}

