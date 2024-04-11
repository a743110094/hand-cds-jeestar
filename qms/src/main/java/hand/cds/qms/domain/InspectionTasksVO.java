package hand.cds.qms.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 质检任务
 * @author 49944
 * @TableName inspection_tasks
 */
@Data
public class InspectionTasksVO implements Serializable {


    /**
     * 订单号
     */
    private String orderNo;

}