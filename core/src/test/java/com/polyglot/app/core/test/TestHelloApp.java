package com.polyglot.app.core.test;

import static com.polyglot.app.core.jni.HelloApp.hello;

/**
 * @author Pengtao Qiu
 */
public class TestHelloApp {

    public static void main(String[] args) {
        hello("Java\r\n");
        hello("Cpp");
    }
}
