package com.test.news

object NewsFactory {
    fun create(id: Int): NewsItem {
        return when (id % 4) {
            0 -> NewsImageItem(id, "زیبایی اعماق اقبانوس", "https://www.uwphotographyguide.com/images/Articles/d810-settings-88.jpg")
            1 -> NewsTextItem(id, "We Can Start Over And Make The World A Better Place")
            2 -> NewsAdItem(id)
            else -> NewsTextItem(id, "example@live.com")
        }
    }
}