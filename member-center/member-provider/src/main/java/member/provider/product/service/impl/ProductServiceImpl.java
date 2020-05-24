package member.provider.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import member.center.com.Utils.PageBean;
import member.provider.common.entity.Condition;
import member.provider.product.entity.Product;
import member.provider.product.mapper.ProductMapper;
import member.provider.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
