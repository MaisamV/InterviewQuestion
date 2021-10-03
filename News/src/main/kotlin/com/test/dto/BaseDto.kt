package com.test.dto

open class BaseDto<out T> (
    val isSuccess: Boolean,
    val data: T?,
    val error: String?
)