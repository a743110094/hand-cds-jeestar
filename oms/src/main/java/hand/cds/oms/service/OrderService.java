package hand.cds.oms.service;

import hand.cds.oms.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import hand.cds.oms.domain.OrderVO;

import java.util.List;

/**
* @author 49944
* @description 针对表【order】的数据库操作Service
* @createDate 2024-04-09 00:02:43
*/
public interface OrderService extends IService<Order> {

    /**
     * 分页获取
     *
     * @param page 页
     * @return {@link List}<{@link Order}>
     */
    List<Order> getByPage(Integer page);

    void importOrder(OrderVO orderVO);
}
