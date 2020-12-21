package com.finances.easy.userservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User (@Id val id: String?,
                 val name: String = "",
                 @Indexed(unique = true) val username: String = "",
                 @Indexed(unique = true) val email: String = "")