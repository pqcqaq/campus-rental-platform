package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.po.LikeRecords;
import zust.online.crp.entity.po.User;
import zust.online.crp.mapper.LikeRecordsMapper;
import zust.online.crp.service.LikeRecordsService;
import zust.online.crp.utils.ContextUtil;

/**
 * @author qcqcqc
 */
@Service
public class LikeRecordsServiceImpl extends ServiceImpl<LikeRecordsMapper, LikeRecords> implements LikeRecordsService {
    @Override
    public boolean likePost(Long postId) {
        // 先查一下当前用户是否已经点赞过了
        User currentUser = ContextUtil.getCurrentUser();
        LambdaQueryWrapper<LikeRecords> eq = new LambdaQueryWrapper<LikeRecords>()
                .eq(LikeRecords::getCreateBy, currentUser.getId())
                .eq(LikeRecords::getPostId, postId);
        LikeRecords one = this.getOne(eq);
        if (one != null) {
            // 如果已经点赞过了，就取消点赞
            this.removeById(one.getId());
            return false;
        }

        LikeRecords likeRecords = new LikeRecords();
        likeRecords.setPostId(postId);
        return this.save(likeRecords);
    }
}
