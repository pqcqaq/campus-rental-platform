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
import zust.online.crp.service.ViewRecordsService;
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
    @Resource
    private ViewRecordsService viewRecordsService;

    /**
     * 首页：获取帖子列表
     *
     * @param page 页码
     * @param size 每页大小
     * @return 帖子列表
     */
    @GetMapping("/list/{page}/{size}")
    public Result<PageResult<PostVo>> getPostList(@PathVariable Integer page, @PathVariable Integer size) {
        PageResult<PostVo> postVoPageResult = getPageList(page, size,
                new LambdaQueryWrapper<Post>()
                        .orderByDesc(Post::getCreateTime), false);
        return Result.success(postVoPageResult);
    }

    /**
     * 发布帖子
     *
     * @param postVo 帖子信息
     * @return 结果
     */
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/publish")
    public Result<String> publishPost(@Valid @RequestBody PostVo postVo) {
        log.info("发布帖子：{}", postVo);
        Post savePo = postVo.toSavePo();
        postService.save(savePo);
        return Result.success("发布成功");
    }

    /**
     * 点赞帖子
     *
     * @param postId 帖子id
     * @return 结果
     */
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

    /**
     * 收藏帖子
     *
     * @param postId 帖子id
     * @return 结果
     */
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

    /**
     * 获取用户发布的帖子
     *
     * @param page 页码
     * @param size 每页大小
     * @return 帖子列表
     */
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/publish/{page}/{size}/{userId}")
    public Result<PageResult<PostVo>> pagePublishPosts(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Long userId) {
        User currentUser = ContextUtil.getCurrentUser();
        if (currentUser == null) {
            return Result.error(500, "请先登录");
        }
        PageResult<PostVo> postVoPageResult = getPageList(page, size,
                new LambdaQueryWrapper<Post>()
                        .eq(Post::getCreateBy, userId)
                        .orderByDesc(Post::getCreateTime), false);
        return Result.success(postVoPageResult);
    }

    /**
     * 获取用户收藏的帖子
     *
     * @param page 页码
     * @param size 每页大小
     * @return 帖子列表
     */
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/collect/{page}/{size}/{userId}")
    public Result<PageResult<PostVo>> pageCollectPosts(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Long userId) {
        User currentUser = ContextUtil.getCurrentUser();
        if (currentUser == null) {
            return Result.error(500, "请先登录");
        }
        List<Long> collectPostIds = collectInfoService.getCollectPostIdsByUserId(userId);
        if (collectPostIds.isEmpty()) {
            return Result.success(new PageResult<>());
        }

        PageResult<PostVo> postVoPageResult = getPageList(page, size,
                new LambdaQueryWrapper<Post>()
                        .in(Post::getId, collectPostIds)
                        .orderByDesc(Post::getCreateTime), false);
        // 使用收藏的顺序排序
        List<PostVo> postVos = sortPostVosByIdList(collectPostIds, postVoPageResult.getData());
        postVoPageResult.setData(postVos);
        return Result.success(postVoPageResult);
    }

    /**
     * 获取用户点赞的帖子
     *
     * @param postId 帖子id
     * @return 帖子列表
     */
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

    /**
     * 获取帖子详情
     *
     * @param postId 帖子id
     * @return 帖子详情
     */
    @GetMapping("/{postId}")
    public Result<PostVo> getPostDetail(@PathVariable Long postId) {
        log.info("获取帖子详情：{}", postId);
        PostVo postVo = postService.getById(postId, true);
        viewRecordsService.addRecord(postId);
        return Result.success(postVo);
    }

    /**
     * 获取帖子列表
     *
     * @param page               页码
     * @param size               每页大小
     * @param lambdaQueryWrapper 查询条件
     * @param detailed           是否获取详情
     * @return 帖子列表
     */
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

    /**
     * 使用id列表对帖子列表排序
     *
     * @param ids     id列表
     * @param postVos 帖子列表
     * @return 排序后的帖子列表
     */
    private List<PostVo> sortPostVosByIdList(List<Long> ids, List<PostVo> postVos) {
        PostVo[] postVoArray = new PostVo[postVos.size()];
        for (PostVo postVo : postVos) {
            int i = ids.indexOf(Long.parseLong(postVo.getId()));
            if (i == -1) {
                continue;
            }
            postVoArray[i] = postVo;
        }
        return List.of(postVoArray);
    }
}
