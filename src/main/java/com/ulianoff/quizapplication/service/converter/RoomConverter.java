package com.ulianoff.quizapplication.service.converter;

import com.ulianoff.quizapplication.model.domain.Room;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.RoomDto;
import com.ulianoff.quizapplication.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomConverter {

    RoomDto roomToRoomDto(Room room);

    Room roomDtoToRoom(RoomDto roomDto);

    UserDto userToUserDto(User user);
}
