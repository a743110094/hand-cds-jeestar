package hand.cds.oms.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @TableName order
 */
@TableName(value = "order", schema = "cds_oms")
public class Order implements Serializable {
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

    /**
     *
     */
    private String origin;
    /**
     * 履行单号
     */
    private String fullfillNo;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFullfillNo() {
        return fullfillNo;
    }

    public void setFullfillNo(String fullfillNo) {
        this.fullfillNo = fullfillNo;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(name, order.name) && Objects.equals(no, order.no) && Objects.equals(origin, order.origin) && Objects.equals(fullfillNo, order.fullfillNo) && Objects.equals(createdTime, order.createdTime) && Objects.equals(createdBy, order.createdBy) && Objects.equals(updatedTime, order.updatedTime) && Objects.equals(updatedBy, order.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, no, origin, fullfillNo, createdTime, createdBy, updatedTime, updatedBy);
    }
}