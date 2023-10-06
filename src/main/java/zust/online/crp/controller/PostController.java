package zust.online.crp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zust.online.crp.entity.PageResult;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.po.Post;
import zust.online.crp.entity.po.User;
import zust.online.crp.entity.vo.PostVo;
import zust.online.crp.service.CollectInfoService;
import zust.online.crp.service.LikeRecordsService;
import zust.online.crp.service.PostService;
import zust.online.crp.utils.ContextUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author qcqcqc
 */
@RestController
@RequestMapping("/posts")
@Slf4j
public class PostController {

    @Resource
    private PostService postService;
    @Resource
    private LikeRecordsService likeRecordsService;
    @Resource
    private CollectInfoService collectInfoService;

    @GetMapping("/list/{page}/{size}")
    public Result<PageResult<PostVo>> getPostList(@PathVariable Integer page, @PathVariable Integer size) {
        PageResult<PostVo> postVoPageResult = getPageList(page, size,
                new LambdaQueryWrapper<Post>()
                        .orderByDesc(Post::getCreateTime), false);
        return Result.success(postVoPageResult);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/publish")
    public Result<String> publishPost(@Valid @RequestBody PostVo postVo) {
        log.info("发布帖子：{}", postVo);
        Post savePo = postVo.toSavePo();
        postService.save(savePo);
        return Result.success("发布成功");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/like/{postId}")
    public Result<Boolean> likePost(@PathVariable Long postId) {
        log.info("点赞帖子：{}", postId);
        boolean b = likeRecordsService.likePost(postId);
        if (!b) {
            return Result.error(200, "取消点赞成功", false);
        }
        return Result.success(200, "点赞成功", true);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/collect/{postId}")
    public Result<Boolean> collectPost(@PathVariable Long postId) {
        log.info("收藏帖子：{}", postId);
        boolean b = collectInfoService.collectPost(postId);
        if (!b) {
            return Result.error(200, "取消收藏成功", false);
        }
        return Result.success(200, "收藏成功", true);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/publish/{page}/{size}")
    public Result<PageResult<PostVo>> pagePublishPosts(@PathVariable Integer page, @PathVariable Integer size) {
        User currentUser = ContextUtil.getCurrentUser();
        if (currentUser == null) {
            return Result.error(500, "请先登录");
        }
        PageResult<PostVo> postVoPageResult = getPageList(page, size,
                new LambdaQueryWrapper<Post>()
                        .eq(Post::getCreateBy, currentUser.getId())
                        .orderByDesc(Post::getCreateTime), false);
        return Result.success(postVoPageResult);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/collect/{page}/{size}")
    public Result<PageResult<PostVo>> pageCollectPosts(@PathVariable Integer page, @PathVariable Integer size) {
        User currentUser = ContextUtil.getCurrentUser();
        if (currentUser == null) {
            return Result.error(500, "请先登录");
        }
        List<Long> collectPostIds = collectInfoService.getCollectPostIdsByUserId(currentUser.getId());
        if (collectPostIds.isEmpty()) {
            return Result.success(new PageResult<>());
        }

        PageResult<PostVo> postVoPageResult = getPageList(page, size,
                new LambdaQueryWrapper<Post>()
                        .in(Post::getId, collectPostIds)
                        .orderByDesc(Post::getCreateTime), false);
        return Result.success(postVoPageResult);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{postId}")
    public Result<String> delPost(@PathVariable Long postId) {
        log.info("删除帖子：{}", postId);
        boolean b = postService.removeById(postId);
        if (!b) {
            return Result.error(200, "删除失败", "删除失败");
        }
        return Result.success(200, "删除成功", "删除成功");
    }

    @GetMapping("/{postId}")
    public Result<PostVo> getPostDetail(@PathVariable Long postId) {
        log.info("获取帖子详情：{}", postId);
        Post post = postService.getById(postId);
        PostVo postVo = postService.transPostToPostVo(post, true);
        return Result.success(postVo);
    }

    private PageResult<PostVo> getPageList(int page, int size, LambdaQueryWrapper<Post> lambdaQueryWrapper, boolean detailed) {
        Page<Post> postPage = new Page<>(page, size);
        Page<Post> page1 = postService.page(postPage, lambdaQueryWrapper);
        List<PostVo> postVoList = postService.transPostListToPostVoList(page1.getRecords(), detailed);
        PageResult<PostVo> postVoPageResult = new PageResult<>();
        postVoPageResult.setTotal(page1.getTotal());
        postVoPageResult.setPageNum(page1.getCurrent());
        postVoPageResult.setPageSize(page1.getSize());
        postVoPageResult.setData(postVoList);
        return postVoPageResult;
    }
}
