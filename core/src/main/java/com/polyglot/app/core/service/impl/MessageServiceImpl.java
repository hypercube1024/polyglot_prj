package com.polyglot.app.core.service.impl;

import com.polyglot.app.api.model.MessageRequest;
import com.polyglot.app.api.model.MessageResponse;
import com.polyglot.app.api.service.MessageService;
import com.polyglot.app.core.jni.MessageServiceJniWrap;

/**
 * @author Pengtao Qiu
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public MessageResponse send(MessageRequest request) {
        MessageServiceJniWrap.MessageRequestJni requestJni = new MessageServiceJniWrap.MessageRequestJni();
        requestJni.setId(request.getId());
        requestJni.setContent(request.getContent());
        MessageServiceJniWrap.MessageResponseJni responseJni = MessageServiceJniWrap.send(requestJni);
        MessageResponse resp = new MessageResponse();
        resp.setCode(responseJni.getCode());
        resp.setMsg(responseJni.getMsg());
        resp.setTs(responseJni.getTs());
        resp.setContent(responseJni.getContent());
        return resp;
    }

}
