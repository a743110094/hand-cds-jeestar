package hand.cds.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hand.cds.mall.domain.MallOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author 49944
 * @description 针对表【order】的数据库操作Mapper
 * @createDate 2024-04-09 00:02:43
 * @Entity generator.domain.Order
 */
@Mapper
public interface MallOrderMapper extends BaseMapper<MallOrder> {

    @Update("""
            UPDATE cds_mall.mall_order
            SET status = CASE
                             WHEN TIMESTAMPDIFF(HOUR, created_time, NOW()) <= 0.5 THEN '备货中'
                             WHEN TIMESTAMPDIFF(HOUR, created_time, NOW()) > 0.5 AND TIMESTAMPDIFF(HOUR, created_time, NOW()) <= 1 THEN '备货完成'
                             WHEN TIMESTAMPDIFF(HOUR, created_time, NOW()) > 1 AND TIMESTAMPDIFF(HOUR, created_time, NOW()) <= 2 THEN '待发货'
                             WHEN TIMESTAMPDIFF(HOUR, created_time, NOW()) > 2 AND TIMESTAMPDIFF(HOUR, created_time, NOW()) <= 3 THEN '待揽收'
                             WHEN TIMESTAMPDIFF(HOUR, created_time, NOW()) > 3 AND TIMESTAMPDIFF(HOUR, created_time, NOW()) <= 5 THEN '已出库'
                             WHEN TIMESTAMPDIFF(HOUR, created_time, NOW()) > 5 AND TIMESTAMPDIFF(HOUR, created_time, NOW()) <= 40 THEN '运输中'
                             WHEN TIMESTAMPDIFF(HOUR, created_time, NOW()) > 40 AND TIMESTAMPDIFF(HOUR, created_time, NOW()) <= 45 THEN '派送中'
                             WHEN TIMESTAMPDIFF(HOUR, created_time, NOW()) > 45 AND TIMESTAMPDIFF(HOUR, created_time, NOW()) <= 48 THEN '已签收'
                          END
            where TIMESTAMPDIFF(DAY , created_time, NOW()) < 30 AND status <> '已完成'
                        """)
    void updatePending();

    @Update("""
            UPDATE cds_mall.mall_order
            SET delivery_time = current_timestamp
            where status ='已出库'
            and delivery_time is null and  TIMESTAMPDIFF(DAY , created_time, NOW()) < 30
                        """)
    void updateDeliveryTime();
    @Update("""
            UPDATE cds_mall.mall_order
            SET receipt_time = current_timestamp
            where cds_mall.mall_order.status ='已签收'
            and receipt_time is null  and  TIMESTAMPDIFF(DAY , created_time, NOW()) < 30
                        """)
    void updateReceiptTime();

    @Update("""
            update cds_mall.mall_order
            set status       = '已完成',
                updated_time = CURRENT_TIMESTAMP
            where TIMESTAMPDIFF(HOUR, created_time, NOW()) > 48  and  TIMESTAMPDIFF(DAY , created_time, NOW()) < 30
            """)
    void updateFinished();
}




