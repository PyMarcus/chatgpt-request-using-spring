package com.marcus.controller

import com.marcus.service.ChatGPTService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bot")
class ChatGPTController {

    @Autowired
    private lateinit var service: ChatGPTService

    @GetMapping("/chat")
    fun chat(@RequestParam("prompt") prompt: String): Any{
        return service.chat(prompt)
    }
}