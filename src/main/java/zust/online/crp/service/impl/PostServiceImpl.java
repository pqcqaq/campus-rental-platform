package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.po.*;
import zust.online.crp.entity.vo.CommentVo;
import zust.online.crp.entity.vo.Image;
import zust.online.crp.entity.vo.PostVo;
import zust.online.crp.mapper.PostMapper;
import zust.online.crp.service.*;
import zust.online.crp.utils.ContextUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qcqcqc
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Resource
    AttachmentService attachmentService;
    @Resource
    private CommentService commentService;
    @Resource
    private CollectInfoService collectInfoService;
    @Resource
    private UserService userService;
    @Resource
    private LikeRecordsService likeRecordsService;
    @Resource
    private ShareRecordsService shareRecordsService;
    @Resource
    private ViewRecordsService viewRecordsService;

    @Override
    public PostVo transPostToPostVo(Post post) {
        // 获取当前用户
        User currentUser = ContextUtil.getCurrentUser();
        // 获取作者信息
        User author = userService.getById(post.getCreateBy());
        List<CommentVo> commentVos = commentService.getCommentVosByPostId(post.getId());
        Long collectNum = collectInfoService.getCollectNumsByPostId(post.getId());
        List<Long> imgs = post.getImgs();
        List<Image> images = imgs.stream().map(img -> {
            Image image = new Image();
            image.setId(img);
            image.setShow(true);
            return image;
        }).toList();
        LambdaQueryWrapper<CollectInfo> eq1 = new LambdaQueryWrapper<CollectInfo>()
                .eq(CollectInfo::getPostId, post.getId())
                .eq(CollectInfo::getCreateBy, currentUser.getId());
        CollectInfo collectInfo = collectInfoService.getOne(eq1);
        boolean isCollect = collectInfo != null;

        long count = likeRecordsService.count(new LambdaQueryWrapper<LikeRecords>().eq(LikeRecords::getPostId, post.getId()));
        LambdaQueryWrapper<LikeRecords> eq = new LambdaQueryWrapper<LikeRecords>()
                .eq(LikeRecords::getPostId, post.getId())
                .eq(LikeRecords::getCreateBy, currentUser.getId());
        LikeRecords likeRecords = likeRecordsService.getOne(eq);
        boolean isLike = likeRecords != null;

        List<ShareRecords> shareRecords = shareRecordsService.list(new LambdaQueryWrapper<ShareRecords>().eq(ShareRecords::getPostId, post.getId()));
        List<ViewRecords> viewRecords = viewRecordsService.list(new LambdaQueryWrapper<ViewRecords>().eq(ViewRecords::getPostId, post.getId()));

        return post.toVo(
                images,
                commentVos,
                author,
                count,
                (long) commentVos.size(),
                (long) collectNum.intValue(),
                isLike,
                isCollect,
                shareRecords.size(),
                viewRecords.size(),
                1
        );
    }

    @Override
    public List<PostVo> transPostListToPostVoList(List<Post> postList) {
        ArrayList<PostVo> postVos = new ArrayList<>();
        for (Post post : postList) {
            PostVo postVo = this.transPostToPostVo(post);
            postVos.add(postVo);
        }
        return postVos;
    }
}
