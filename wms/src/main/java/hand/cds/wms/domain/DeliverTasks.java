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
@TableName(value ="deliver_tasks",schema = "cds_wms")
@Data
public class DeliverTasks implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String no;
    private String orderNo;


    /**
     * 出库/入库
     */
    private String type;

    /**
     * 初始化/作业中/已取消/已完成
     */
    private String status;

    /**
     * 
     */
    private Integer qty;

    /**
     * 仓库名称
     */
    private String warehouse;

    /**
     * 子库名称
     */
    private String subInventory;

    /**
     * 货位名称
     */
    private String lot;

    /**
     * 
     */
    private String unit;

    /**
     * 
     */
    private String origin;
    private String itemCode;
    /**
     * 作业人员
     */
    private String operator;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}