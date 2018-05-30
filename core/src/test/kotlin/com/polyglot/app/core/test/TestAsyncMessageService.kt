package com.polyglot.app.core.test

import com.polyglot.app.api.model.MessageRequest
import com.polyglot.app.core.service.impl.AsyncMessageServiceImpl

/**
 * @author Pengtao Qiu
 */
fun main(args: Array<String>) {
    val service = AsyncMessageServiceImpl()

    var request = MessageRequest()
    request.id = 1
    request.content = "async msg"
    service.send(request) { println(it) }

    request = MessageRequest()
    request.id = 2
    request.content = "12345678"
    service.send(request) { println(it) }
}