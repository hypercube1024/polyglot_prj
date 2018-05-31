# Polyglot programming example
This project demonstrates how to build Kotlin, Java, and C++ codes using maven.   
The first, run command
```shell
mvn clean install
```

And then, import project to your IDE and run `TestAsyncMessageService.kt`
```kotlin
fun main(args: Array<String>) {
    val service = AsyncMessageServiceImpl()

    var request = MessageRequest()
    request.id = 1
    request.content = "async msg"
    service.send(request) { println(it) }

    request = MessageRequest()
    request.id = 2
    request.content = "12345678"
    service.send(request) { println(it) }
}
```

The console shows:
```
MessageResponse{code=0, msg='ok', content='received async message', ts=1527753202439}
MessageResponse{code=-1, msg='error request', content='', ts=1527753202453}
```

This example demonstrates the Kotlin invokes C++ service implementation using JNI.