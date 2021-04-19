package member.provider.controller;

import member.provider.common.annotation.Cache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Cache
@RestController
public class TestController {
    @Value("${server.port}")
    private String port;



    @RequestMapping("/docker")
    public String doker(){

        return "Hello docker!" + port;
    }



    @PostMapping("/listTest")
    public String listTest(List<Integer> list){

        return list.get(0) + "";
    }


}
