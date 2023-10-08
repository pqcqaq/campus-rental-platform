package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.PageResult;
import zust.online.crp.entity.po.Comment;
import zust.online.crp.entity.vo.CommentVo;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.mapper.CommentMapper;
import zust.online.crp.service.CommentService;
import zust.online.crp.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author qcqcqc
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private UserService userService;


    @Override
    public List<CommentVo> getCommentVosByPostId(Long postId) {
        List<Comment> list = this.list(new LambdaQueryWrapper<Comment>()
                .eq(Comment::getPostId, postId)
                // parentId为null的是一级评论
                .isNull(Comment::getParentId)
                .orderByDesc(Comment::getCreateTime)
        );
        return this.transCommentListToCommentVoList(list);
    }

    @Override
    public PageResult<CommentVo> pageCommentVosByPostId(Integer page, Integer size, Long postId) {
        Page<Comment> commentPage = new Page<>(page, size);
        Page<Comment> page1 = this.page(commentPage, new LambdaQueryWrapper<Comment>()
                .eq(Comment::getPostId, postId)
                // parentId为null的是一级评论
                .isNull(Comment::getParentId)
                .orderByDesc(Comment::getCreateTime)
        );
        List<CommentVo> commentVos = this.transCommentListToCommentVoList(page1.getRecords());
        PageResult<CommentVo> commentVoPageResult = new PageResult<>();
        commentVoPageResult.setTotal(page1.getTotal());
        commentVoPageResult.setPageNum(page1.getCurrent());
        commentVoPageResult.setPageSize(Long.valueOf(size));
        commentVoPageResult.setData(commentVos);
        return commentVoPageResult;
    }

    private List<CommentVo> getCommentsForCommentsByParentIds(Long parentId) {
        if (parentId == null) {
            return new ArrayList<>();
        }
        List<Comment> list = this.list(new LambdaQueryWrapper<Comment>()
                .in(Comment::getParentId, parentId)
                .orderByDesc(Comment::getCreateTime)
        );
        return this.transCommentListToCommentVoList(list);
    }

    private List<CommentVo> transCommentListToCommentVoList(List<Comment> commentList) {
        ArrayList<CommentVo> commentVos = new ArrayList<>();
        for (Comment comment : commentList) {
            commentVos.add(this.transCommentToCommentVo(comment));
        }
        return commentVos;
    }

    private CommentVo transCommentToCommentVo(Comment comment) {
        Long userId = comment.getCreateBy();
        UserVo byId = userService.getById(userId, true);
        List<CommentVo> commentsForCommentsByParentIds = getCommentsForCommentsByParentIds(comment.getId());
        return comment.toVo(byId, commentsForCommentsByParentIds);
    }
}
