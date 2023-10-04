package zust.online.crp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author qcqcqc
 */
@Mapper
public interface PostStatisticsInfoMapper {

    /**
     * 获取喜欢热门帖子的id
     *
     * @param topNum 热门帖子的数量
     * @return 热门帖子的id
     */
    @Select("SELECT post_id AS count FROM like_records GROUP BY post_id ORDER BY count DESC LIMIT #{topNum}")
    List<Long> getLikeHotPostIds(int topNum);

    /**
     * 获取收藏热门帖子的id
     *
     * @param topNum 热门帖子的数量
     * @return 热门帖子的id
     */
    @Select("SELECT post_id AS count FROM collect GROUP BY post_id ORDER BY count DESC LIMIT #{topNum}")
    List<Long> getCollectHotPostIds(int topNum);
}
