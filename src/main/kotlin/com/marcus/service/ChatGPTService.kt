package com.marcus.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.marcus.vo.request.ChatGPTRequestVO
import com.marcus.vo.request.Message
import com.marcus.vo.response.ChatGPTErrorResponseVO
import com.marcus.vo.response.ChatGPTResponseVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject
import java.util.logging.Logger

@Service
class ChatGPTService {
    private val logger: Logger = Logger.getLogger(ChatGPTService::class.java.name)

    @Value("\${openai.model}")
    private val model: String? = null

    @Value("\${openai.url}")
    private val apiUrl: String? = null

    @Autowired
    private lateinit var template: RestTemplate

    fun chat(prompt: String): Any{
        logger.info("Starting chatting...")
        val messages = arrayListOf(Message("user", prompt))

        val request = ChatGPTRequestVO(model!!, messages, 0.1F)

        try {
            val response = template.postForObject(apiUrl ?:"", request, ChatGPTResponseVO::class.java)
            return response!!
        }catch (e: Exception){
            logger.info(e.message)
            return ChatGPTErrorResponseVO(e.message!!,429 )
        }

    }
}