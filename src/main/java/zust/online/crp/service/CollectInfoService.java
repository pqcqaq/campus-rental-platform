package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zust.online.crp.entity.po.CollectInfo;

/**
 * @author qcqcqc
 */
public interface CollectInfoService extends IService<CollectInfo> {
    /**
     * 根据帖子id获取收藏数
     * @param id 帖子id
     * @return 收藏数
     */
    Long getCollectNumsByPostId(Long id);
}
