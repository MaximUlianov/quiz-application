package com.ulianoff.quizapplication.service.user;

import com.ulianoff.quizapplication.dao.UserRepository;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.UserDto;
import com.ulianoff.quizapplication.service.converter.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserConverter converter;

    @Override
    public UserDto save(UserDto userDto) {

        User user = converter.userDtoToUser(userDto);
        repository.save(user);

        userDto.setId(String.valueOf(user.getId()));

        return userDto;
    }

    @Override
    public UserDto getById(String id) {

        return converter.userToUserDto(repository.findById(Long.parseLong(id)).orElseThrow());
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public boolean delete(UserDto entity) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public UserDto updateUser(UserDto user) {

        return null; //repository.save(user);
    }
}
