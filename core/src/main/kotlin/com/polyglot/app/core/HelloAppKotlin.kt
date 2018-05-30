package com.polyglot.app.core

import com.polyglot.app.core.jni.HelloApp.hello

/**
 * @author Pengtao Qiu
 */
fun main(args: Array<String>) {
    hello("Kotlin\r\n")
    hello("Java\r\n")
    hello("Cpp\r\n")
}
