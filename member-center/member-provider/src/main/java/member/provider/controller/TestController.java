package member.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/docker")
    public String doker(){
        return "Hello docker!" + port;
    }

}
