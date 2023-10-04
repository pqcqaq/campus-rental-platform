package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zust.online.crp.entity.po.LikeRecords;

/**
 * @author qcqcqc
 */
public interface LikeRecordsService extends IService<LikeRecords> {
    /**
     * 点赞帖子
     * @param postId 帖子id
     * @return 是否已经点赞
     */
    boolean likePost(Long postId);
}
