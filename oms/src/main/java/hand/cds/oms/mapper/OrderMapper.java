package hand.cds.oms.mapper;

import hand.cds.oms.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
* @author 49944
* @description 针对表【mallOrder】的数据库操作Mapper
* @createDate 2024-04-09 00:02:43
* @Entity generator.domain.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Update("""
            update cds_oms.mallOrder
            set status       = '在途',
                updated_time = CURRENT_TIMESTAMP
            where created_time >= CURRENT_TIMESTAMP - 180
              AND created_time <= CURRENT_TIMESTAMP
            """)
    void updatePending();

    @Update("""
            update cds_oms.mallOrder
            set status       = '已完成',
                updated_time = CURRENT_TIMESTAMP
            where created_time <= CURRENT_TIMESTAMP - 3600 * 8
            """)
    void updateFinished();
}




