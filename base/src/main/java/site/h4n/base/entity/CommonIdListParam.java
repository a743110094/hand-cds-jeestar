package site.h4n.base.entity;


import lombok.Data;

  import java.util.Set;

/**
 * 通用 ID 列表参数
 *
 * @author Heaven96
 * @date 2024/03/24
 */
@Data
public class CommonIdListParam {

    Set<Long> ids;
}
