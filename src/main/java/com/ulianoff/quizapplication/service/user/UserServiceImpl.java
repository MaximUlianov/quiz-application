package com.ulianoff.quizapplication.service.user;

import com.ulianoff.quizapplication.dao.UserRepository;
import com.ulianoff.quizapplication.model.domain.Role;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.UserDto;
import com.ulianoff.quizapplication.service.converter.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final long ADMIN_ROLE_ID = 1L;

    private static final long USER_ROLE_ID = 2L;

    private final UserRepository repository;

    private final UserConverter converter;

    @Override
    public UserDto createUser(UserDto userDto) {

        return saveUser(userDto, USER_ROLE_ID);
    }

    @Override
    public UserDto createAdminUser(UserDto userDto) {

        return saveUser(userDto, ADMIN_ROLE_ID);
    }

    private UserDto saveUser(UserDto userDto, long id) {

        User user = converter.userDtoToUser(userDto);
        user.setPassword(user.getPassword());

        Role role = new Role();
        role.setId(id);

        user.setRole(role);
        repository.save(user);

        userDto.setId(String.valueOf(user.getId()));

        return userDto;
    }

    @Override
    public UserDto getUserById(String id) {

        return converter.userToUserDto(repository.findById(Long.parseLong(id)).orElseThrow());
    }

    @Override
    public void deleteUserById(String id) {

    }

    @Override
    public List<UserDto> getAllUsers() {

        return repository.findAll()
                .stream()
                .map(converter::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {

        return null; //repository.save(user);
    }
}
