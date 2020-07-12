package member.provider.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import member.provider.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Autowired
    private MyConfig myConfig;

    @Value("${server.port}")
    private String port;

    //从nacos中动态获取配置参数指定注解--针对springboot和nacos的集成 ,springcloud则不是这写法
    //@NacosValue(value = "${city}", autoRefreshed = true)
    @Value("${city}")
    private String city;

    @RequestMapping("nacos")
    public String nacos(){
        return "port:" + port;
    }


    @RequestMapping("city")
    public String city(){
        return "city:" + city;
    }

    @RequestMapping("myconfig")
    public String myconfig(){
        return "id:" +myConfig.getId() +"....."+"secret:"+ myConfig.getSecret() ;
    }
}

