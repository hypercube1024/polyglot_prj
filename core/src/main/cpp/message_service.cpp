#include <string>
#include <cstdio>
#include <sys/time.h>

static int64_t getCurrentTime() {
    struct timeval tv{};
    gettimeofday(&tv, nullptr);
    return tv.tv_sec * 1000 + tv.tv_usec / 1000;
}

namespace polyglot {
    namespace model {
        class MessageRequestJni {
        private:
            int id;
            std::string content;
        public:
            int getId() const {
                return id;
            }

            void setId(int id) {
                MessageRequestJni::id = id;
            }

            const std::string &getContent() const {
                return content;
            }

            void setContent(const std::string &content) {
                MessageRequestJni::content = content;
            }
        };

        class MessageResponseJni {
        private:
            int code;
            std::string msg;
            std::string content;
            int64_t ts;
        public:
            int getCode() const {
                return code;
            }

            void setCode(int code) {
                MessageResponseJni::code = code;
            }

            const std::string &getMsg() const {
                return msg;
            }

            void setMsg(const std::string &msg) {
                MessageResponseJni::msg = msg;
            }

            const std::string &getContent() const {
                return content;
            }

            void setContent(const std::string &content) {
                MessageResponseJni::content = content;
            }

            int64_t getTs() const {
                return ts;
            }

            void setTs(int64_t ts) {
                MessageResponseJni::ts = ts;
            }
        };
    }

    namespace service {
        using polyglot::model::MessageRequestJni;
        using polyglot::model::MessageResponseJni;

        MessageResponseJni *send(MessageRequestJni *request) {
            auto *resp = new MessageResponseJni();
            resp->setTs(getCurrentTime());
            if (request->getContent() == "test msg") {
                resp->setCode(0);
                resp->setContent("received test message");
                resp->setMsg("ok");

            } else {
                resp->setCode(-1);
                resp->setMsg("error request");
            }
            return resp;
        }



        class MsgCallback {
        public:
            virtual ~MsgCallback() = default;
            
            virtual void call(MessageResponseJni * response) {

            }
        };

        void asyncSend(MessageRequestJni *request, MsgCallback *callback) {
            auto *resp = new MessageResponseJni();
            resp->setTs(getCurrentTime());
            if (request->getContent() == "async msg") {
                resp->setCode(0);
                resp->setContent("received async message");
                resp->setMsg("ok");

            } else {
                resp->setCode(-1);
                resp->setMsg("error request");
            }
            callback->call(resp);
        }
    }

}




