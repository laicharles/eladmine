package gree.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author charleslai@139.com
 * @Title: TestController
 * @ProjectName eladmin
 * @Description: TODO
 * @date 2019-03-2614:12
 */

@RestController
public class TestController {
    @GetMapping("/set-session")
    public Object writeSession(String sessionVal, HttpSession httpSession) {
        System.out.println("Param 'sessionVal' = " + sessionVal);
        httpSession.setAttribute("sessionVal", sessionVal);
        return sessionVal;
    }
    @GetMapping("/get-session")
    public Object readSession(HttpSession httpSession) {
        Object obj = httpSession.getAttribute("sessionVal");
        System.out.println("'sessionVal' in Session = " + obj);
        return obj;
    }
}