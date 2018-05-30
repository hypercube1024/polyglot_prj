package com.polyglot.app.core.service.impl

import com.polyglot.app.api.model.MessageRequest
import com.polyglot.app.api.model.MessageResponse
import com.polyglot.app.api.service.AsyncMessageService
import com.polyglot.app.core.jni.MessageServiceJniWrap

/**
 * @author Pengtao Qiu
 */
class AsyncMessageServiceImpl : AsyncMessageService {
    override fun send(request: MessageRequest, callback: (response: MessageResponse) -> Unit) {
        val requestJni = MessageServiceJniWrap.MessageRequestJni()
        requestJni.id = request.id
        requestJni.content = request.content
        MessageServiceJniWrap.asyncSend(requestJni, object : MessageServiceJniWrap.MsgCallback() {
            override fun call(responseJni: MessageServiceJniWrap.MessageResponseJni) {
                val resp = MessageResponse()
                resp.code = responseJni.code
                resp.msg = responseJni.msg
                resp.ts = responseJni.ts
                resp.content = responseJni.content
                callback.invoke(resp)
            }
        })
    }
}