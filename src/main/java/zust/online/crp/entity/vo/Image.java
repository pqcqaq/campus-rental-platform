package zust.online.crp.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qcqcqc
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private String id;
    private String url;
    private Boolean show;
}
