package member.provider.designpattern;

import member.provider.designpattern.impl.BackDook;
import member.provider.designpattern.impl.BlackEnemy;
import member.provider.designpattern.impl.GivenGreenLight;

/**
 * 实际效果
 */
public class ZhaoYun {

    public static void main(String[] args) {
        Context context;

        System.out.println("使用第一个锦囊");
        context = new Context(new BackDook());
        context.operate();
        System.out.println("===========================\n");

        System.out.println("使用第二个锦囊");
        context = new Context(new GivenGreenLight());
        context.operate();
        System.out.println("===========================\n");



        System.out.println("使用第三个锦囊");
        context = new Context(new BlackEnemy());
        context.operate();

    }
}
