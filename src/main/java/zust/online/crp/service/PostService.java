package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zust.online.crp.entity.po.Post;
import zust.online.crp.entity.vo.PostVo;

import java.util.List;

/**
 * @author qcqcqc
 */
public interface PostService extends IService<Post> {
    PostVo transPostToPostVo(Post post);

    List<PostVo> transPostListToPostVoList(List<Post> postList);

    List<PostVo> getTopHotPostVos(int topNum);
}
