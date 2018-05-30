package com.polyglot.app.api.service;

import com.polyglot.app.api.model.MessageRequest;
import com.polyglot.app.api.model.MessageResponse;

/**
 * @author Pengtao Qiu
 */
public interface MessageService {
    MessageResponse send(MessageRequest request);
}
