package com.project.kotlinaplication.Domain.UseCase

import com.project.kotlinaplication.Data.Repository.UserRepository
import com.project.kotlinaplication.Domain.Entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)

    }
}