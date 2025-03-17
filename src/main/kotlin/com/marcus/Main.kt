package com.marcus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChatgptSpringApplication

fun main(args: Array<String>) {
	runApplication<ChatgptSpringApplication>(*args)
}
