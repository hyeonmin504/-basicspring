package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private  final  LogDeomoService logDeomoService;
    //private final ObjectProvider<MyLogger> myLoggerProvider;
    //마이 로그는 사작하고 바로 실행하는 것이 아니라 고객 요청이 와야 실행 가능하므로 지연 시켜야한다. 그래서 프로바이더 사용

    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI().toString();
        //MyLogger myLogger = myLoggerProvider.getObject(); // 이 때 실행한다.
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDeomoService.logic("testID");
        return "OK";
    }
}
