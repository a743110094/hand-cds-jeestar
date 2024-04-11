package hand.cds.mall.service;

import hand.cds.mall.domain.MallOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import hand.cds.mall.domain.MallOrderVO;

import java.util.List;

/**
* @author 49944
* @description 针对表【order】的数据库操作Service
* @createDate 2024-04-09 00:02:43
*/
public interface MallOrderService extends IService<MallOrder> {

    /**
     * 分页获取
     *
     * @param page 页
     * @return {@link List}<{@link MallOrder}>
     */
    List<MallOrder> getByPage(Integer page);

    void create(MallOrderVO mallOrderVO);
}
