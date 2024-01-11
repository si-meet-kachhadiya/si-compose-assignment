package com.si_assesment_task_compose.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.si_assesment_task_compose.model.MatchDetail.MatchDetailModel
import com.si_assesment_task_compose.utils.MatchRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = MatchRepository()

    private val _matches = MutableLiveData<MatchDetailModel>()
    val matches: LiveData<MatchDetailModel> = _matches

    fun fetchMatches() {
        viewModelScope.launch {
            try {
                val matches = repository.getMatches()
                _matches.value = matches
            } catch (e: Exception) {

            }
        }
    }

}