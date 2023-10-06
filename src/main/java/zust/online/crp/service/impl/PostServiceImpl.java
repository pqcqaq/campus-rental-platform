package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.po.*;
import zust.online.crp.entity.vo.*;
import zust.online.crp.mapper.PostMapper;
import zust.online.crp.mapper.PostStatisticsInfoMapper;
import zust.online.crp.service.*;
import zust.online.crp.utils.ContextUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author qcqcqc
 */
@Service
@Slf4j
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
    @Resource
    private PostStatisticsInfoMapper postStatisticsInfoMapper;

    @Override
    public PostVo transPostToPostVo(Post post, boolean detailed) {
        // 获取当前用户
        User currentUser = ContextUtil.getCurrentUser();
        // 获取作者信息
        UserVo author = userService.getById(post.getCreateBy(), detailed);

        List<CommentVo> commentVos = null;
        if (detailed) {
            // 获取评论信息
            commentVos = commentService.getCommentVosByPostId(post.getId());
        }
        long commentCount = commentService.count(new LambdaQueryWrapper<Comment>().eq(Comment::getPostId, post.getId()));
        // 获取收藏数
        Long collectNum = collectInfoService.getCollectNumsByPostId(post.getId());
        List<Long> imgs = post.getImgs();
        List<Image> images = new ArrayList<>();
        // 获取图片信息
        for (Long imgId : imgs) {
            Image image = new Image();
            image.setId(String.valueOf(imgId));
            image.setShow(true);
            images.add(image);
        }
        boolean isCollect = false;
        boolean isLike = false;
        long count = viewRecordsService.countPostViewRecords(post.getId());

        if (currentUser != null) {
            // 获取当前用户是否收藏
            LambdaQueryWrapper<CollectInfo> eq1 = new LambdaQueryWrapper<CollectInfo>()
                    .eq(CollectInfo::getPostId, post.getId())
                    .eq(CollectInfo::getCreateBy, currentUser.getId());
            CollectInfo collectInfo = collectInfoService.getOne(eq1);
            isCollect = collectInfo != null;

            // 获取当前用户是否点赞
            LambdaQueryWrapper<LikeRecords> eq = new LambdaQueryWrapper<LikeRecords>()
                    .eq(LikeRecords::getPostId, post.getId())
                    .eq(LikeRecords::getCreateBy, currentUser.getId());
            LikeRecords likeRecords = likeRecordsService.getOne(eq);
            isLike = likeRecords != null;
        }

        List<ShareRecords> shareRecords = shareRecordsService.list(new LambdaQueryWrapper<ShareRecords>().eq(ShareRecords::getPostId, post.getId()));
        List<ViewRecords> viewRecords = viewRecordsService.list(new LambdaQueryWrapper<ViewRecords>().eq(ViewRecords::getPostId, post.getId()));
        // 如果是自己的帖子，可以编辑
        boolean editable = currentUser != null && (currentUser.getId().equals(post.getCreateBy()) || currentUser.isAdmin());
        return post.toVo(
                images,
                commentVos,
                author,
                count,
                commentCount,
                collectNum,
                isLike,
                isCollect,
                shareRecords.size(),
                viewRecords.size(),
                1,
                editable
        );
    }

    @Override
    public List<PostVo> transPostListToPostVoList(List<Post> postList, boolean detailed) {
        ArrayList<PostVo> postVos = new ArrayList<>();
        for (Post post : postList) {
            PostVo postVo = this.transPostToPostVo(post, detailed);
            postVos.add(postVo);
        }
        return postVos;
    }

    @Override
    public List<SwiperItemVo> getTopHotPostVos(int topNum) {
        // 统计id
        int topNum1 = topNum >>> 1;
        List<Long> likeHotPostIds = postStatisticsInfoMapper.getLikeHotPostIds(topNum1);
        int topNum2 = topNum - topNum1;
        List<Long> collectHotPostIds = postStatisticsInfoMapper.getCollectHotPostIds(topNum2);
        // 获取热门帖子
        List<Post> likeHotPost = this.listByIds(likeHotPostIds);
        List<Post> collectHotPost = this.listByIds(collectHotPostIds);

        //noinspection ComparatorMethodParameterNotUsed
        Set<SwiperItemVo> swiperItemVos = new TreeSet<>((newValue, oldValue) -> {
            if (newValue.getPostId().equals(oldValue.getPostId())) {
                // 如果postId一样，只保留一个，并将类型改为collect like
                oldValue.setType(oldValue.getType().concat(" ").concat(newValue.getType()));
                return 0;
            }
            return 1;
        });

        for (Post listToPostVo : likeHotPost) {
            SwiperItemVo swiperItemVo = new SwiperItemVo();
            swiperItemVo.setImg(String.valueOf(listToPostVo.getImgs().get(0)));
            swiperItemVo.setText(listToPostVo.getTitle());
            swiperItemVo.setPostId(String.valueOf(listToPostVo.getId()));
            swiperItemVo.setType("like");
            swiperItemVos.add(swiperItemVo);
        }

        for (Post listToPostVo : collectHotPost) {
            SwiperItemVo swiperItemVo = new SwiperItemVo();
            swiperItemVo.setImg(String.valueOf(listToPostVo.getImgs().get(0)));
            swiperItemVo.setText(listToPostVo.getTitle());
            swiperItemVo.setPostId(String.valueOf(listToPostVo.getId()));
            swiperItemVo.setType("collect");
            swiperItemVos.add(swiperItemVo);
        }

        return new ArrayList<>(swiperItemVos);
    }

    @Override
    public boolean checkIsDelete(Long postId) {
        Post post = this.getById(postId);
        return post == null;
    }

    @Override
    public PostVo getById(Long postId, boolean detailed) {
        Post post = this.getById(postId);
        if (post == null) {
            return null;
        }
        return this.transPostToPostVo(post, detailed);
    }

    private List<Post> listByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        return this.list(new LambdaQueryWrapper<Post>().in(Post::getId, ids));
    }
}
