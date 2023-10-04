package zust.online.crp.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zust.online.crp.entity.po.User;

import java.util.List;

/**
 * @author qcqcqc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostVo {
    private Long id;
    private String title;
    private String intro;
    private List<Image> imgs;
    private String createTime;
    private String updateTime;
    private User author;
    private Long likeNum;
    private Long commentNum;
    private Long collectNum;
    private List<CommentVo> comments;
    private Boolean isLike;
    private Boolean isCollect;
    private Integer shareNum;
    private Integer viewNum;
    private Integer status;
}
