package com.test

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapterFactory
import com.test.news.NewsAdItem
import com.test.news.NewsImageItem
import com.test.news.NewsItem
import com.test.news.NewsTextItem

object GsonProvider {
    private val gson: Gson = GsonBuilder().create()
    val newsGson = GsonBuilder().registerTypeAdapter(NewsItem::class.java, NewsItemAdapter()).create()

    private fun getTypeFactory(): TypeAdapterFactory {
        val adapter: RuntimeTypeAdapterFactory<NewsItem> = RuntimeTypeAdapterFactory
            .of(NewsItem::class.java)
            .registerSubtype(NewsImageItem::class.java)
            .registerSubtype(NewsTextItem::class.java)
            .registerSubtype(NewsAdItem::class.java)
        return adapter
    }

    fun get() = gson

}