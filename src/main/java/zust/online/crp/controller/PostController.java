package zust.online.crp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zust.online.crp.entity.PageResult;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.po.Post;
import zust.online.crp.entity.vo.PostVo;
import zust.online.crp.service.PostService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qcqcqc
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    @GetMapping("/list/{page}/{size}")
    public Result<PageResult<PostVo>> getPostList(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Post> postPage = new Page<>(page, size);
        Page<Post> page1 = postService.page(postPage);
        List<Post> records = page1.getRecords();
        List<PostVo> postVoList = postService.transPostListToPostVoList(records);
        PageResult<PostVo> postVoPageResult = new PageResult<>();
        postVoPageResult.setTotal(page1.getTotal());
        postVoPageResult.setPageNum(page1.getCurrent());
        postVoPageResult.setPageSize(page1.getSize());
        postVoPageResult.setData(postVoList);
        return Result.success(postVoPageResult);
    }
}
