package member.provider.test;

import member.provider.biz.product.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiwuTest {

    @Autowired
    private IProductService productService;


    @Test
    public void test2(){
        System.out.println("===="+productService.getClass().getName());
        productService.parent();
    }

}

