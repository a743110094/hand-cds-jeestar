package hand.cds.qms.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 质检任务
 * @author 49944
 * @TableName inspection_tasks
 */
@TableName(value ="inspection_tasks",schema = "cds_qms")
@Data
public class InspectionTasks implements Serializable {
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
     * 质检单号
     */
    private String no;
    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Integer qty;

    /**
     * 
     */
    private Integer passQty;

    /**
     * 
     */
    private Integer rejectQty;

    /**
     * 
     */
    private String unit;

    /**
     * 
     */
    private String origin;

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