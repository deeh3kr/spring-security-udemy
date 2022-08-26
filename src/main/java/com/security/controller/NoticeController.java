package com.security.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @SneakyThrows
    @GetMapping("/notices")
    public String getNotices(){
        return "Here are notices";
    }
}
