package com.baron.mycomposeapplication.screens.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baron.domain.model.NetworkResponse
import com.baron.domain.usecase.AppRequestsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appRequestsUseCase: AppRequestsUseCase
) : ViewModel() {

    private val _response = MutableStateFlow(NetworkResponse())
    val response: StateFlow<NetworkResponse> = _response.asStateFlow()


    fun getResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            _response.emit(appRequestsUseCase.getResponse())
        }
    }
}