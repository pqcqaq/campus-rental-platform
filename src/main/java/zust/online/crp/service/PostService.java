package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zust.online.crp.entity.po.Post;
import zust.online.crp.entity.vo.PostVo;
import zust.online.crp.entity.vo.SwiperItemVo;

import java.util.List;

/**
 * @author qcqcqc
 */
public interface PostService extends IService<Post> {
    PostVo transPostToPostVo(Post post, boolean detailed);

    List<PostVo> transPostListToPostVoList(List<Post> postList, boolean detailed);

    List<SwiperItemVo> getTopHotPostVos(int topNum);

    boolean checkIsDelete(Long postId);
}
