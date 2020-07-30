package member.provider.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import member.center.com.Utils.PageBean;
import member.center.com.api.UserService;
import member.center.com.pojo.User;
import member.provider.common.entity.Condition;
import member.provider.product.entity.Product;
import member.provider.product.mapper.ProductMapper;
import member.provider.product.service.IProductService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Code-Builder
 * @since 2020-05-02
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    private ProductMapper productMapper;

   @Autowired
   private UserService userService;

    @Override
    public List<Product> selectList() {
            Condition<Product> condition = Condition.create();
            condition.eq(Product.Column.ID,2)
                    .or()
                    .eq(Product.Column.PODUCT_NAME,"汽车");
        return productMapper.selectList(condition);
    }

    @Override
    public Product selectOne(int id) {
        Condition<Product> condition = Condition.create();
        condition.eq(Product.Column.ID,id);
        return productMapper.selectOne(condition);
    }

    @Override
    public PageBean selectPage() {
        PageHelper.startPage(1,3);
        List<Product> list = productMapper.findPage();
        return new PageBean(list);
    }



    @Override
    public void parent() {
        /**
         * 事务生效必须进过代理对象才能生效
         * 方法内的调用 应为没有进过代理所以事务不生效
         *
         */



        Product parent  = new Product();
        parent.setPoductName("parent").setNum(10);
        this.save(parent);
        //child(); //方法内的调用就算child()加了事务注解也不会生效
        try{
            // 代理类调用--从aop上下文中获取代理对象(方法内的调用 事务生效)
            IProductService   proxy   = (IProductService)AopContext.currentProxy();
            System.out.println(proxy.getClass().getName());
            proxy.child();
        }catch (Exception e){
            System.out.println(e);
        }

    }


    @Override
    @Transactional
    public void child() {
        User user = new User();
        user.setUsername("allen").setPwd("123456");
        userService.save(user);
        int a =1/0;
    }




}
