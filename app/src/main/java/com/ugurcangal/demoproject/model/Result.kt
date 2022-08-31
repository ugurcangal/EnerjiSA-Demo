package com.ugurcangal.demoproject.model

data class Result(
    val errorCode: Any,
    val explanation: Any,
    val isSuccess: Boolean,
    val jobID: Any,
    val message: Any,
    val params: Params,
    val requestContextID: String,
    val resultObject: List<ResultObject>
)