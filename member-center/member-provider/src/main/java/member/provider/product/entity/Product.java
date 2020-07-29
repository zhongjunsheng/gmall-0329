package member.provider.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Code-Builder
 * @since 2020-05-02
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @TableField("poduct_name")
    @ApiModelProperty(value = "商品名称")
    private String poductName;

    @TableField("num")
    @ApiModelProperty(value = "购买数量")
    private Integer num;

    @TableField("uid")
    @ApiModelProperty(value = "买家ID")
    private Integer uid;

    /**
     * <p>
     * -字段
     * </p>
     */
    public static class Column {
        private Column() {
        }

        /**
         * 
         */
        public static final String ID = "id";
        /**
         * 
         */
        public static final String PODUCT_NAME = "poduct_name";
        /**
         * 
         */
        public static final String NUM = "num";
        /**
         * 
         */
        public static final String UID = "uid";
   }
    /**
     * <p>
     * -属性
     * </p>
     */
    public static class Field {
        private Field() {
        }

        /**
         * 
         */
        public static final String ID = "id";
        /**
         * 
         */
        public static final String PODUCT_NAME = "poductName";
        /**
         * 
         */
        public static final String NUM = "num";
        /**
         * 
         */
        public static final String UID = "uid";
   }

    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPoductName() {
        return poductName;
    }

    public Product setPoductName(String poductName) {
        this.poductName = poductName;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public Product setNum(Integer num) {
        this.num = num;
        return this;
    }

    public Integer getUid() {
        return uid;
    }

    public Product setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
        ", id=" + id +
        ", poductName=" + poductName +
        ", num=" + num +
        ", uid=" + uid +
        "}";
    }
}
