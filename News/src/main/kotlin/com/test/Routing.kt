package com.test

import com.test.dto.NewsListDto
import com.test.news.NewsFactory
import com.test.news.NewsItem
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*
import java.util.concurrent.atomic.AtomicInteger


fun Route.routes() {
    route("/api/v1") {
        route("/news") {
            get {
                handleEvent()
            }
        }
        route("/news/") {
            get {
                handleEvent()
            }
        }
    }
}

val counter = AtomicInteger(1)

suspend fun PipelineContext<Unit, ApplicationCall>.handleEvent() {
    try {
        var c = counter.getAndAdd(1)
        var list: ArrayList<NewsItem> = arrayListOf()
        for (i in 0..c) {
            list.add(NewsFactory.create(i))
        }
        list.reverse()
        var text = GsonProvider.newsGson.toJson(NewsListDto(true, list, null))
        call.respondText(
            text,
            ContentType.Application.Json,
            HttpStatusCode.OK
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}