package com.project.kotlinaplication.Injection

import android.content.Context
import androidx.room.Room
import com.project.kotlinaplication.Data.Local.AppDatabase
import com.project.kotlinaplication.Data.Local.DatabaseDao
import com.project.kotlinaplication.Data.Repository.UserRepository
import com.project.kotlinaplication.Domain.UseCase.CreateUserUseCase
import com.project.kotlinaplication.Domain.UseCase.GetUserUseCase
import com.project.kotlinaplication.Presentation.Main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.get
import org.koin.dsl.module
import java.security.AccessControlContext

val appModule = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get())}
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()

}
