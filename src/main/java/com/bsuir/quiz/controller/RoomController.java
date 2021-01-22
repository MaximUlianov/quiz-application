package com.bsuir.quiz.controller;

import com.bsuir.quiz.facade.RoomFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiv1/room")
public class RoomController {

    private RoomFacade roomFacade;

    @Autowired
    public RoomController(RoomFacade roomFacade) {
        this.roomFacade = roomFacade;
    }
}
