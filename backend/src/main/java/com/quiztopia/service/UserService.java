package com.quiztopia.service;

import com.quiztopia.model.User;
import com.quiztopia.dto.UserDto;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
