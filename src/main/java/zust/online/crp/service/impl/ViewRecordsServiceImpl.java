package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.po.User;
import zust.online.crp.entity.po.ViewRecords;
import zust.online.crp.mapper.ViewRecordsMapper;
import zust.online.crp.service.ViewRecordsService;
import zust.online.crp.utils.ContextUtil;

/**
 * @author qcqcqc
 */
@Service
@Slf4j
public class ViewRecordsServiceImpl extends ServiceImpl<ViewRecordsMapper, ViewRecords> implements ViewRecordsService {
    @Override
    public void addRecord(Long postId) {
        User currentUser = ContextUtil.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        ViewRecords viewRecords = new ViewRecords();
        viewRecords.setPostId(postId);
        viewRecords.setCreateBy(currentUser.getId());
        // 如果已经存在则不再添加
        try {
            this.save(viewRecords);
        } catch (Exception e) {
            log.info("用户再次浏览帖子，不再添加浏览记录");
        }
    }

    @Override
    public long countPostViewRecords(Long id) {
        return this.count(new LambdaQueryWrapper<ViewRecords>()
                .eq(ViewRecords::getPostId, id));
    }
}
