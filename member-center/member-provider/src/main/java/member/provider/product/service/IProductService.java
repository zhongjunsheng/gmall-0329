package member.provider.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import member.center.com.Utils.PageBean;
import member.provider.product.entity.Product;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Code-Builder
 * @since 2020-05-02
 */
public interface IProductService extends IService<Product> {

    List<Product> selectList();

    Product selectOne(int id);

    PageBean selectPage();
}
