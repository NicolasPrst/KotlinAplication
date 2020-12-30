package com.project.kotlinaplication.Data.Repository

import com.project.kotlinaplication.Data.Local.DatabaseDao
import com.project.kotlinaplication.Data.Local.Models.UserLocal
import com.project.kotlinaplication.Data.Local.Models.toData
import com.project.kotlinaplication.Data.Local.Models.toEntity
import com.project.kotlinaplication.Domain.Entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {
    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String): User? {
        val userLocal: UserLocal? = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }
}