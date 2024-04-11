package site.h4n.base.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 通用数据状态
 *
 * @author Heaven96
 * @date 2024/03/21
 */
public enum CommonDataStatus {

    /**
     * 未生效
     * 此状态是为了支持分布式的二阶段提交，不可以展示给用户
     */
    NOT_TAKE_EFFECT(-1, "初始化未生效"),
    /**
     * 待审核
     */
    AUDITING(5, "待审核"),
    /**
     * 正常
     */
    COMMON(10, "正常"),
    /**
     * 审核未通过
     */
    AUDIT_NOT_PASS(20, "审核未通过"),
    /**
     * 已过期
     */
    EXPIRE(30, "已过期"),
    /**
     * 已作废
     */
    DEPRECATED(40, "已作废"),
    /**
     * 已冻结
     */
    FREEZE(80, "已冻结"),
    /**
     * 已停用
     */
    DISABLED(90, "已停用"),
    /**
     * 回滚作废(用于乐观锁冲突 预写数据的回滚)
     */
    ROLL_BACKED(100, "回滚作废");

    @EnumValue
    private final int code;
    @JsonValue
    private final String desc;

    CommonDataStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    // Getters for code and desc
    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
