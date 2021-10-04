package com.test

import com.test.news.NewsImageItem
import io.ktor.server.cio.*

fun main(args: Array<String>) {
    GsonProvider.newsGson.toJson(NewsImageItem(0, "زیبایی اعماق اقبانوس", "https://www.uwphotographyguide.com/images/Articles/d810-settings-88.jpg"))
    EngineMain.main(args)
}