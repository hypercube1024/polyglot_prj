package com.polyglot.app.core.test

import com.polyglot.app.core.jni.HelloApp.hello
import org.junit.Test

/**
 * @author Pengtao Qiu
 */
class TestHelloAppKotlin {

    @Test
    fun test() {
        hello("Kotlin\r\n")
        hello("Java\r\n")
        hello("Cpp\r\n")
    }
}