package com.example.btufinalandroidproject.presentation.auth.screen.profile

sealed interface ProfileScreenEvent {
    data object SignOut : ProfileScreenEvent
}