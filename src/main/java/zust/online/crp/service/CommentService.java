package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zust.online.crp.entity.PageResult;
import zust.online.crp.entity.po.Comment;
import zust.online.crp.entity.vo.CommentVo;

import java.util.List;

/**
 * @author qcqcqc
 */
public interface CommentService extends IService<Comment> {
    List<CommentVo> getCommentVosByPostId(Long postId);

    PageResult<CommentVo> pageCommentVosByPostId(Integer page, Integer size, Long postId);
}
