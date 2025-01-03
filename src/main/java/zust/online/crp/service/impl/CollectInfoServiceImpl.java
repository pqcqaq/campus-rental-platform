package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.po.CollectInfo;
import zust.online.crp.mapper.CollectInfoMapper;
import zust.online.crp.service.CollectInfoService;
import zust.online.crp.service.PostService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qcqcqc
 */
@Service
public class CollectInfoServiceImpl extends ServiceImpl<CollectInfoMapper, CollectInfo> implements CollectInfoService {
    @Resource
    @Lazy
    private PostService postService;

    @Override
    public Long getCollectNumsByPostId(Long id) {
        return this.count(new LambdaQueryWrapper<CollectInfo>().eq(CollectInfo::getPostId, id));
    }

    @Override
    public boolean collectPost(Long postId) {
        // 先查一下当前用户是否已经收藏过了
        CollectInfo one = this.getOne(new LambdaQueryWrapper<CollectInfo>()
                .eq(CollectInfo::getCreateBy, 1L)
                .eq(CollectInfo::getPostId, postId));
        if (one != null) {
            // 如果已经收藏过了，就取消收藏
            this.removeById(one.getId());

            return false;
        }

        CollectInfo collectInfo = new CollectInfo();
        collectInfo.setPostId(postId);
        return this.save(collectInfo);
    }

    @Override
    public List<Long> getCollectPostIdsByUserId(Long userId) {
        List<CollectInfo> list = this.list(new LambdaQueryWrapper<CollectInfo>()
                .eq(CollectInfo::getCreateBy, userId)
                .orderByDesc(CollectInfo::getCreateTime)
        );
        return list.stream().map(CollectInfo::getPostId).toList();
    }
}
