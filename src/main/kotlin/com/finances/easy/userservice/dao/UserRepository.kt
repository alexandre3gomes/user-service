package com.finances.easy.userservice.dao

import com.finances.easy.userservice.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: ReactiveCrudRepository<User, String>