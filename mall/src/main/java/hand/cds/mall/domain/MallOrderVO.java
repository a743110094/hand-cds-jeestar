package hand.cds.mall.domain;

import lombok.Data;



@Data
public class MallOrderVO {

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 物料编码
     */
    private String itemCode;

    /**
     * 商品数量
     */
    private Integer itemQty;

}
