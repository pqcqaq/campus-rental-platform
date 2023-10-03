package zust.online.crp.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qcqcqc
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwiperItemVo {
    private String img;
    private String text;
}
