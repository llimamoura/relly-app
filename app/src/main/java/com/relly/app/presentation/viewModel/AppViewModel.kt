package com.relly.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.relly.app.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    authRepository: AuthRepository,
) : ViewModel() {
    val isLoggedInFlow: StateFlow<Boolean> = authRepository.isLoggedInFlow
}
