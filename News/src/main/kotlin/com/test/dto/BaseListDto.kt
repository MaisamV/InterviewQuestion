package com.test.dto

open class BaseListDto<T>(isSuccess: Boolean, data: List<T>?, error: String?) :
    BaseDto<List<T>>(isSuccess, data, error) {
}