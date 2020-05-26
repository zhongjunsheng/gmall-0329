package member.provider.product.controller;

import member.center.com.Utils.PageBean;
import member.provider.common.entity.Condition;
import member.provider.product.entity.Product;
import member.provider.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("product")
    public Object getById(){
        Product byId = productService.getById(1);
        return byId;
    }
    @RequestMapping("productOne")
    public Object getOne(){
        Condition<Product> condition = Condition.create();
        condition.eq(Product.Column.ID,2);
        Product one = productService.getOne(condition);
        return one;
    }

    @RequestMapping("selectList")
    public Object selectList(){
        List<Product> list  = productService.selectList();
        return list;
    }

    @RequestMapping("selectOne")
    public Object selectOne(){
        Product one  = productService.selectOne(4);
        return one;
    }

    @RequestMapping("batchSave")
    public Object batchInsert(){
        List<Product> list = new ArrayList<>();
        Product product = new Product();
        product.setPoductName("allen");
        Product product2 = new Product();
        product2.setPoductName("pp");
        Product product3 = new Product();
        product3.setPoductName("Al");
        list.add(product);
        list.add(product2);
        list.add(product3);
        boolean b = productService.saveBatch(list);
        return b;
    }

    @RequestMapping("insertOrUpdate")
    public Object insertOrUpdate(){
        Product product = new Product();
        product.setId(5);
        product.setPoductName("allen");
        product.setNum(100);
        boolean b = productService.saveOrUpdate(product);
        return b;
    }

    @RequestMapping("findPage")
    public Object findPage(){
        PageBean pageBean =  productService.selectPage();
        return pageBean;
    }
}