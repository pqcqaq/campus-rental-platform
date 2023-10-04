package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.po.Comment;
import zust.online.crp.entity.po.User;
import zust.online.crp.entity.vo.CommentVo;
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
        List<Comment> list = this.list(new LambdaQueryWrapper<Comment>().eq(Comment::getPostId, postId));
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
        User byId = userService.getById(userId);
        CommentVo commentVo = new CommentVo();
        commentVo.setDetail(comment.getCommentDetail());
        commentVo.setCreateTime(comment.getCreateTime());
        commentVo.setId(String.valueOf(comment.getId()));
        commentVo.setAuthor(byId);
        return commentVo;
    }
}
