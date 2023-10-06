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
public class CommentVo {
    private String id;
    private UserVo author;
    private String detail;
    private List<CommentVo> comments;
    private String createTime;
}
