package com.finances.easy.userservice.router

import com.finances.easy.userservice.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.*

@Configuration
class UserRouter {
    @Bean
    fun userRoutes(handler: UserHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
                .route(GET("/"), HandlerFunction { req: ServerRequest -> handler.list(req) })
                .andRoute(POST("/"), HandlerFunction { req: ServerRequest -> handler.create(req) })
                .andRoute(GET("/{id}"), HandlerFunction { req: ServerRequest -> handler.retrieve(req) })
                .andRoute(PUT("/"), HandlerFunction { req: ServerRequest -> handler.update(req) })
                .andRoute(DELETE("/{id}"), HandlerFunction { req: ServerRequest -> handler.delete(req) })
    }
}
