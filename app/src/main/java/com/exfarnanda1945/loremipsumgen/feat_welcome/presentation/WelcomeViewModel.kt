package com.exfarnanda1945.loremipsumgen.feat_welcome.presentation

import com.exfarnanda1945.loremipsumgen.core.navigation.AppRoutes
import com.exfarnanda1945.loremipsumgen.core.ui.event.UiEvent
import com.exfarnanda1945.loremipsumgen.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor() : BaseViewModel() {
    fun onEvent(event: WelcomeEvent) {
        when (event) {
            is WelcomeEvent.OnNavigateToGen -> sendUiEvent(UiEvent.NavigateTo(AppRoutes.GeneratorScreen.route))
        }
    }

}