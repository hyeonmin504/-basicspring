package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDeomoService {
    //프로바이더 덕분에 빈의 생성 지연
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    private final MyLogger myLogger;
    public void logic(String id) {
        //MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
