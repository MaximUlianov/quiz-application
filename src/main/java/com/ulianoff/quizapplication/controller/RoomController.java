package com.ulianoff.quizapplication.controller;

import com.ulianoff.quizapplication.facade.RoomFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomFacade roomFacade;
}
