package com.ugurcangal.demoproject.model

data class Menu(
    val errorCode: Any,
    val errorMessage: Any,
    val isMaintenance: Boolean,
    val logUrl: String,
    val requestId: String,
    val result: Result,
    val sid: String,
    val statusCode: Int,
    val validationErrorMessages: Any
)