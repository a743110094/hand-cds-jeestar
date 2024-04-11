package hand.cds.qms.mapper;

import hand.cds.qms.domain.InspectionTasks;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
* @author 49944
* @description 针对表【inspection_tasks(质检任务)】的数据库操作Mapper
* @createDate 2024-04-09 20:40:03
* @Entity hand.cds.qms.domain.InspectionTasks
*/
@Mapper
public interface InspectionTasksMapper extends BaseMapper<InspectionTasks> {

    /**
     * 更新检查
     */
    @Update("""
            update cds_qms.inspection_tasks
            set status     = '质检中',
                pass_qty   = 0,
                reject_qty = 0
            where created_time >= CURRENT_TIMESTAMP - 3600 * 6
              AND created_time <= current_timestamp
            """)
    void updateInspectioning();

    /**
     * 更新完成
     */
    @Update("""
            update cds_qms.inspection_tasks
            set status     = '已完成',
                pass_qty   = qty - inspection_tasks.qty % 3,
                reject_qty = inspection_tasks.qty % 3
            where created_time <= CURRENT_TIMESTAMP - 3600 * 6
            """)
    void updateFinished();
}




