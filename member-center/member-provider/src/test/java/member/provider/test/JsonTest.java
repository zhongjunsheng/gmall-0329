package member.provider.test;

import member.center.com.pojo.User;
import member.provider.common.utils.JsonUtils;

public class JsonTest {

    public static void main(String[] args) {




        User user = new User();

        user.setUsername("Allen");
        user.setAddress("zhanjiang");

        String jsonStr = JsonUtils.toJsonStr(user);
        //System.out.println(jsonStr);


        String s = jsonStr.replaceAll("\"", "").replace("{","").replace("}","");

        String replace = s.replace(":", ": ").replace(",","\r\n");
        System.out.println(replace);


        String  ss = "allen";

        String[] split = ss.split(",");

        System.out.println(split.length);

        String permission = "1";
        String repl = permission.replace("1", "可押货")
                .replace("2", "可配送")
                .replace("3", "自购下单")
                .replace("4", "可退货")
                .replace("5", "代客下单")
                .replace("6", "禁止登陆")
                .replace("7", "取消资格")
                .replace(",","、");


        System.out.println(permission);
        System.out.println(repl);

    }
}
