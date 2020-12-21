package com.finances.easy.userservice.dao

import com.finances.easy.userservice.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository: ReactiveCrudRepository<User, String> {

    fun findByEmail(email: String): Mono<User>
}