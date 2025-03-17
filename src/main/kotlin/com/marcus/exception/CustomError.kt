package com.marcus.exception

import com.marcus.vo.response.ChatGPTErrorResponseVO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.NoHandlerFoundException

@ControllerAdvice
class CustomError {

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleNotFound(ex: NoHandlerFoundException): ResponseEntity<String>{
        return ResponseEntity("This route was not Found", HttpStatus.NOT_FOUND)
    }
}