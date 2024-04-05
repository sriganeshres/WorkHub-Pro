package com.work.workhubpro.ui.screens.landing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.work.workhubpro.models.User
import com.work.workhubpro.repository.UserRepository
import com.work.workhubpro.utils.TokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LandingViewModel @Inject constructor( private val tokenManager: TokenManager,private val repo:UserRepository) : ViewModel() { // You can directly use tokenManager here
    val user= repo.user
      fun getTokenManager(): TokenManager {
         return tokenManager
      }
    fun user_from_token(token:String) {
        viewModelScope.launch {
            repo.user_from_token(token)
        }
    }
}