package com.finances.easy.userservice.handler

import com.finances.easy.userservice.dao.UserRepository
import com.finances.easy.userservice.model.User
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class UserHandler (private val userRepository: UserRepository){
    fun list(req: ServerRequest?): Mono<ServerResponse> {
        return ok().body(userRepository.findAll(), Flux::class.java)
    }

    fun create(req: ServerRequest): Mono<ServerResponse> {
        val user = req.bodyToMono(User::class.java)
        return user.flatMap { usr: User ->
            ok().body(userRepository.save(usr), Mono::class.java)
        }
    }

    fun retrieve(req: ServerRequest): Mono<ServerResponse> {
        return ok().body(userRepository.findById(req.pathVariable("id")), Mono::class.java)
    }

    fun update(req: ServerRequest): Mono<ServerResponse> {
        val user = req.bodyToMono(User::class.java)
        return user.flatMap { us: User ->
            ok().body(userRepository.save(us), Mono::class.java).switchIfEmpty(notFound().build())
        }
    }

    fun delete(req: ServerRequest): Mono<ServerResponse> {
        val id = req.pathVariable("id")
        val deletedUser = userRepository.delete(User(id))
        return ok().body(deletedUser, Mono::class.java)
    }
}