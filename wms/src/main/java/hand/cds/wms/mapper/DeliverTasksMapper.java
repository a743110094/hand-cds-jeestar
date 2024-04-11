package hand.cds.wms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hand.cds.wms.domain.DeliverTasks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author 49944
 * @description 针对表【deliver_tasks(质检任务)】的数据库操作Mapper
 * @createDate 2024-04-09 22:24:05
 * @Entity generator.domain.DeliverTasks
 */
@Mapper
public interface DeliverTasksMapper extends BaseMapper<DeliverTasks> {

    @Update("""
            update cds_wms.deliver_tasks
            set status       = '作业中',
                updated_time = CURRENT_TIMESTAMP
            where created_time >= CURRENT_TIMESTAMP - 60
              AND created_time <= CURRENT_TIMESTAMP
            """)
    void updateDelivering();

    @Update("""
            update cds_wms.deliver_tasks
            set status       = '已完成',
                updated_time = CURRENT_TIMESTAMP
            where created_time <= CURRENT_TIMESTAMP - 3600
            """)
    void updateFinished();
}




