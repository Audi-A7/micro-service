package user.dao.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * 基础数据对象
 *
 * @author WangQuanzhou
 * @date 2019-05-24
 */
@Data
public class BasePO {

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 数据有效标准  1-有效  0-无效
     */
    @TableLogic
    private Byte valid;
}
