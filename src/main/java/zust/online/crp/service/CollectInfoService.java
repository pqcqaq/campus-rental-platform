package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zust.online.crp.entity.po.CollectInfo;

import java.util.List;

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

    /**
     * 收藏帖子
     * @param postId 帖子id
     * @return 是否已经收藏
     */
    boolean collectPost(Long postId);

    List<Long> getCollectPostIdsByUserId(Long userId);
}
