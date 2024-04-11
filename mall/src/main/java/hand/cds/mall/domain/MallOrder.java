package hand.cds.mall.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @TableName order
 */
@Data
@TableName(value = "mall_order", schema = "cds_mall")
public class MallOrder implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     *
     */
    private String no;

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     *
     */
    private String origin;

    /**
     * 待支付/待发货/运输中/已签收
     */
    private String status;

    /**
     * 商品数量
     */
    private Integer itemQty;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 物料编码
     */
    private String itemCode;

    /**
     * 物流单号
     */
    private String expressNo;

    /**
     * 支付方式
     */
    private String payType;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 收货时间
     */
    private Date receiptTime;

    /**
     *
     */
    private Date createdTime;

    /**
     *
     */
    private String createdBy;

    /**
     *
     */
    private Date updatedTime;

    /**
     *
     */
    private String updatedBy;
    private Integer pushToJeestar;
}