package zust.online.crp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zust.online.crp.entity.PageResult;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.vo.CommentVo;
import zust.online.crp.service.CommentService;

import javax.annotation.Resource;

/**
 * @author qcqcqc
 */
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("/{page}/{size}/{postId}")
    public Result<PageResult<CommentVo>> getCommentListByPostId(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Long postId) {
        return Result.success(commentService.pageCommentVosByPostId(page, size, postId));
    }
}
