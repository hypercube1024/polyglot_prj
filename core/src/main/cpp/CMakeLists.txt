cmake_minimum_required(VERSION 3.10)
project(polyglot_core)

set(CMAKE_CXX_STANDARD 17)
set(LIB_SRC hello_app.cpp message_service.cpp)

add_library(polyglot_core SHARED ${LIB_SRC})
add_executable(polyglot_core_main hello_app.cpp)
