/*
package com.sevity.authservice.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    //@ResponseStatus(HttpStatus.NOT_FOUND)  // 이 라인을 추가할경우 클라이언트 브라우저에서 보기에 403이 아닌 404가 리턴된다. 단 모든 오류를 404로 리턴하게 됨에 주의..
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
        
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "customErrorPage";
            }
            // 추가적인 상태 코드 처리를 여기에 둘 수 있습니다.
        }
        
        return "customErrorPage";
    }
}
*/