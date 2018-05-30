#include <string>

namespace polyglot {
    void hello(const std::string& msg) {
        printf("Hello %s", msg.data());
    }
}

int main() {
    polyglot::hello("cpp");
}