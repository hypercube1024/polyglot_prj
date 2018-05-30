#include <string>
#include <cstdio>
#include <sys/time.h>

namespace polyglot {
    void hello(const std::string& msg) {
        printf("Hello %s", msg.data());
    }
}

static int64_t getCurrentTime() {
    struct timeval tv{};
    gettimeofday(&tv, nullptr);
    return tv.tv_sec * 1000 + tv.tv_usec / 1000;
}

int main() {
    polyglot::hello("cpp");
    printf("current time: %lld", getCurrentTime());
}