package com.test

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.serialization.*

fun Application.addAllRoot() {
    install(ContentNegotiation) {
        json()
    }
    registerRoutes()
}

fun Application.registerRoutes() {
    routing {
        routes()
    }
}