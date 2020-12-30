package com.project.kotlinaplication.Data.Local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.project.kotlinaplication.Data.Local.Models.UserLocal

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM UserLocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM UserLocal WHERE email LIKE :email LIMIT 1")
    fun findByName(email: String): UserLocal

    @Insert
    fun insert(vararg users: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}