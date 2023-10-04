package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.po.CollectInfo;
import zust.online.crp.mapper.CollectInfoMapper;
import zust.online.crp.service.CollectInfoService;

/**
 * @author qcqcqc
 */
@Service
public class CollectInfoServiceImpl extends ServiceImpl<CollectInfoMapper, CollectInfo> implements CollectInfoService {
    @Override
    public Long getCollectNumsByPostId(Long id) {
        return this.count(new LambdaQueryWrapper<CollectInfo>().eq(CollectInfo::getPostId, id));
    }
}
