package com.radhe.javalinrestapi

import com.radhe.javalinrestapi.utils.ResourceUtil
import io.javalin.Javalin


fun main(args: Array<String>) {

    val port = ResourceUtil.getPort("port")

    if (port == -1) {
        return
    }

    val app = Javalin.create().start(port)
    app.get("/") { ctx -> ctx.result("Hello World") }
}