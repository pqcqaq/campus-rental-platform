package zust.online.crp.controller;

import org.springframework.web.bind.annotation.*;
import zust.online.crp.entity.PageResult;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.dto.CommentParam;
import zust.online.crp.entity.vo.CommentVo;
import zust.online.crp.service.CommentService;

import javax.annotation.Resource;
import javax.validation.Valid;

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

    @PostMapping("/publish")
    public Result<CommentVo> publishComment(@Valid @RequestBody CommentParam commentParam) {
        CommentVo commentVo = commentService.publishComment(commentParam);
        return Result.success(commentVo);
    }
}
