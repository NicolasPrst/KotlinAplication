package com.project.kotlinaplication.Presentation.Main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.kotlinaplication.Domain.Entity.User
import com.project.kotlinaplication.Domain.UseCase.CreateUserUseCase
import com.project.kotlinaplication.Domain.UseCase.GetUserUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun onClickedIncrement(emailUser: String){
        viewModelScope.launch {
            createUserUseCase.invoke(User("test"))
            delay(1000)
            val user = getUserUseCase.invoke("test")
        }
    }
}