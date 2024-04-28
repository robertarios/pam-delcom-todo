package com.ifs21024.lostfound.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ifs21024.lostfound.data.pref.UserModel
import com.ifs21024.lostfound.data.remote.MyResult
import com.ifs21024.lostfound.data.remote.response.DataLoginResponse
import com.ifs21024.lostfound.data.repository.AuthRepository
import com.ifs21024.lostfound.presentation.ViewModelFactory

class LoginViewModel(
    private val authRepository: AuthRepository,
) : ViewModel() {

    fun login(email: String, password: String):
            LiveData<MyResult<DataLoginResponse>> {
        return authRepository.login(email, password).asLiveData()
    }

    suspend fun saveSession(user: UserModel): LiveData<UserModel> {
        return authRepository.saveSession(user).asLiveData()
    }
    companion object {
        @Volatile
        private var INSTANCE: LoginViewModel? = null
        fun getInstance(
            authRepository: AuthRepository
        ): LoginViewModel {
            synchronized(ViewModelFactory::class.java) {
                INSTANCE = LoginViewModel(
                    authRepository
                )
            }
            return INSTANCE as LoginViewModel
        }
    }
}