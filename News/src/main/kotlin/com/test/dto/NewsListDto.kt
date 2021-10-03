package com.test.dto

import com.test.news.NewsItem

class NewsListDto(isSuccess: Boolean, data: List<NewsItem>?, error: String?) :
    BaseDto<List<NewsItem>>(isSuccess, data, error) {
}