package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPanelController {

    @GetMapping
    public String userPanel(){
        return "/user/index";
    }
}
