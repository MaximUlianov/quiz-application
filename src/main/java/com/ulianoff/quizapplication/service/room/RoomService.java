package com.ulianoff.quizapplication.service.room;

import com.ulianoff.quizapplication.model.dto.RoomDto;
import com.ulianoff.quizapplication.service.common.CommonService;

public interface RoomService extends CommonService<RoomDto> {

    RoomDto getRoomByCode(String code);

    RoomDto addUserToRoom(RoomDto roomDto);
}
