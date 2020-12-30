package com.project.kotlinaplication.Presentation.Main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.kotlinaplication.Domain.Entity.User
import com.project.kotlinaplication.Domain.UseCase.CreateUserUseCase
import com.project.kotlinaplication.Domain.UseCase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogIn(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user: User? = getUserUseCase.invoke(emailUser)
            val loginStatus: LoginStatus = if(user != null){
                LoginSuccess(user.email)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }
}