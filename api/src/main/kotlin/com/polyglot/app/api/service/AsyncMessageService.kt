package com.polyglot.app.api.service

import com.polyglot.app.api.model.MessageRequest
import com.polyglot.app.api.model.MessageResponse

/**
 * @author Pengtao Qiu
 */
interface AsyncMessageService {

    fun send(request: MessageRequest, callback: (response: MessageResponse) -> Unit)

}