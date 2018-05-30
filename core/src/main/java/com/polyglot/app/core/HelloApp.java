package com.polyglot.app.core;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Namespace;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

/**
 * @author Pengtao Qiu
 */
@Platform(include="hello_app.cpp")
@Namespace("polyglot")
public class HelloApp {
    static {
        Loader.load();
    }

    public static native void hello(@StdString String msg);
}
