package com.project.kotlinaplication.Domain.UseCase

import com.project.kotlinaplication.Data.Repository.UserRepository
import com.project.kotlinaplication.Domain.Entity.User

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(email: String): User{
        return userRepository.getUser(email)

    }
}