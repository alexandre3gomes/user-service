package com.finances.easy.userservice.router

import com.finances.easy.userservice.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.router

@Configuration
class UserRouter {
    @Bean
    fun userRoutes(handler: UserHandler) = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/") { req -> handler.list(req) }
            GET("/current") { req -> handler.getPrincipal(req) }
            POST("/") { req -> handler.create(req) }
            GET("/{id}") { req -> handler.retrieve(req) }
            PUT("/") { req: ServerRequest -> handler.update(req) }
            DELETE("/{id}") { req -> handler.delete(req) }
        }
    }
}
