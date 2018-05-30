package com.polyglot.app.core.test;

import com.polyglot.app.api.model.MessageRequest;
import com.polyglot.app.api.model.MessageResponse;
import com.polyglot.app.api.service.MessageService;
import com.polyglot.app.core.service.impl.MessageServiceImpl;

/**
 * @author Pengtao Qiu
 */
public class TestMessageService {
    public static void main(String[] args) {
        MessageService service = new MessageServiceImpl();

        MessageRequest request = new MessageRequest();
        request.setId(1);
        request.setContent("test msg");
        MessageResponse response = service.send(request);
        System.out.println(response);

        request = new MessageRequest();
        request.setId(2);
        request.setContent("12345678");
        response = service.send(request);
        System.out.println(response);
    }
}
