package com.marcus.vo.request

data class ChatGPTRequestVO (
    val model: String, val message: ArrayList<Message>, val temperature: Float
)