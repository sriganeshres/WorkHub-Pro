package com.work.workhubpro.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.work.workhubpro.repository.OrganisationCreation
import com.work.workhubpro.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo:OrganisationCreation , private val task: TaskRepository):ViewModel() {
    val workhub = repo.workhub
    val tasks = task.tasks
     fun getworkhub(id:String) {
         // Create a new User instance
        viewModelScope.launch {
            repo.getworkhub(id)
        }
    }
    fun gettasks(id:Int) {
        viewModelScope.launch {
            task.getTaskByUserID(id)
        }
    }
}