package com.ulianoff.quizapplication.service;

import com.ulianoff.quizapplication.model.dto.UserDto;

public interface UserService extends CommonService<UserDto> {

    UserDto updateUser(UserDto user);
}
