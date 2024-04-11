package hand.cds.wms.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 质检任务
 * @TableName deliver_tasks
 */
@Data
public class DeliverTasksVO implements Serializable {

    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private String no;
    private String orderNo;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}