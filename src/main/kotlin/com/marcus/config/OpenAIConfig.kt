package com.marcus.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.web.client.RestTemplate

@Configuration
class OpenAIConfig {

    @Value("\${openai.api_key}")
    private val OPEN_AI_API_KEY: String? = null

    @Bean
    fun template(): RestTemplate{
         val restTemplate = RestTemplate()
         restTemplate.interceptors.add(
                ClientHttpRequestInterceptor{
                    request: HttpRequest, body: ByteArray, execution: ClientHttpRequestExecution ->
                    request.headers.add("Authorization", "Bearer $OPEN_AI_API_KEY")
                    execution.execute(request, body)
                }
         )
        return restTemplate
    }
}