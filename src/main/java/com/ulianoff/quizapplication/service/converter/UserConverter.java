package com.ulianoff.quizapplication.service.converter;

import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
