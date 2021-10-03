package com.test

import com.google.gson.*
import com.test.news.*
import java.lang.reflect.Type


class NewsItemAdapter: JsonSerializer<NewsItem?>, JsonDeserializer<NewsItem> {

    override fun serialize(
        src: NewsItem?, typeOfSrc: Type?,
        context: JsonSerializationContext
    ): JsonElement {
        return context.serialize(src)
    }

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement, typeOfT: Type?,
        context: JsonDeserializationContext
    ): NewsItem {
        val jsonObject: JsonObject = json.asJsonObject
        return context.deserialize(jsonObject, TypeFactory.create(jsonObject))
    }

    companion object {
        private const val TYPE = "type"
    }

    object TypeFactory {
        fun create(jsonObject: JsonObject?): Class<out NewsItem>? {
            val type = jsonObject?.get(TYPE)?.asString
            return when (type) {
                NewsType.TEXT.name -> NewsTextItem::class.java
                NewsType.IMAGE.name -> NewsImageItem::class.java
                NewsType.AD.name -> NewsAdItem::class.java
                else -> null
            }
        }
    }
}