package com.zanqian.modules.entity.app;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author GanQuan
 * @since 2025-05-21
 */
@Getter
@Setter
@ToString
@TableName("z_user")
@Schema(name = "User对象", description = "前台用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，使用UUID生成
     */
    @Schema(description = "用户ID，使用UUID生成")
    @TableId(value = "z_id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 用户邮箱，唯一且不允许为空
     */
    @TableField("z_email")
    @Schema(description = "用户邮箱，唯一且不允许为空")
    private String email;

    /**
     * 用户密码，不允许为空
     */
    @TableField("z_password")
    @Schema(description = "用户密码，不允许为空")
    private String password;

    /**
     * 用户昵称，允许为空
     */
    @TableField("z_nickname")
    @Schema(description = "用户昵称，允许为空")
    private String nickname;

    /**
     * 用户头像，允许为空
     */
    @TableField("z_avatar")
    @Schema(description = "用户头像，允许为空")
    private String avatar;

    /**
     * 逻辑删除标记，0代表未删除，1代表已删除，默认为0
     */
    @TableField("z_deleted")
    @Schema(description = "逻辑删除标记，0代表未删除，1代表已删除，默认为0")
    private Boolean deleted;

    /**
     * 创建时间，不允许为空
     */
    @TableField("z_create_time")
    @Schema(description = "创建时间，不允许为空")
    private Date createTime;

    /**
     * 最后更新时间，不允许为空
     */
    @TableField("z_update_time")
    @Schema(description = "最后更新时间，不允许为空")
    private Date updateTime;
}
