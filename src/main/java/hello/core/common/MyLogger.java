package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

//원래 시작하자마자 mylogger에 @RequiredArgsConstructor때문에 주입받아서 아직 실행되지않아 오류가 뜬다
//하지만 프록시를 통해 프로바이더를 쓴 거 마냥 가짜로 주입해주고 나중에 진짜를 넣어줘 오류를 해결해준다.
@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString(); //개인 id 생성
        System.out.println("[" + uuid + "] request scope bean create:"+this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:"+this);
    }
}
