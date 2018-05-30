package com.polyglot.app.core.jni;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.*;

/**
 * @author Pengtao Qiu
 */
@Platform(include = "message_service.cpp")
public class MessageServiceJniWrap {

    static {
        Loader.load();
    }

    @Namespace("polyglot::model")
    public static class MessageRequestJni extends Pointer {
        static {
            Loader.load();
        }

        public MessageRequestJni() {
            allocate();
        }

        private native void allocate();

        public native int getId();

        public native void setId(int id);

        @StdString
        public native String getContent();

        public native void setContent(@StdString String content);
    }

    @Namespace("polyglot::model")
    public static class MessageResponseJni extends Pointer {
        static {
            Loader.load();
        }

        public MessageResponseJni() {
            allocate();
        }

        private native void allocate();

        public native int getCode();

        public native void setCode(int code);

        @StdString
        public native String getMsg();

        public native void setMsg(@StdString String msg);

        @StdString
        public native String getContent();

        public native void setContent(@StdString String content);

        @Cast("int64_t")
        public native long getTs();

        public native void setTs(@Cast("int64_t") long ts);
    }

    @Namespace("polyglot::service")
    public static native MessageResponseJni send(MessageRequestJni request);

    @Namespace("polyglot::service")
    public static class MsgCallback extends Pointer {
        static {
            Loader.load();
        }

        public MsgCallback() {
            allocate();
        }

        private native void allocate();

        @Virtual
        public native void call(MessageResponseJni response);
    }

    @Namespace("polyglot::service")
    public static native void asyncSend(MessageRequestJni request, MsgCallback callback);
}
