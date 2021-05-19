package com.ulianoff.quizapplication.service.user;

import com.ulianoff.quizapplication.model.dto.UserDto;
import com.ulianoff.quizapplication.service.common.CommonService;

public interface UserService extends CommonService<UserDto> {

    UserDto updateUser(UserDto user);

    UserDto createUser(UserDto userDto);

    UserDto createAdminUser(UserDto userDto);
}
