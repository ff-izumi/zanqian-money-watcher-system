package com.zanqian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ganquan
 * @since 2023-04-28
 */
@TableName("zq_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，使用UUID生成
     */
    private String userId;

    /**
     * 用户邮箱，唯一且不允许为空
     */
    private String email;

    /**
     * 用户密码，不允许为空
     */
    private String password;

    /**
     * 用户昵称，允许为空
     */
    private String nickname;

    /**
     * 用户头像，允许为空
     */
    private String avatar;

    /**
     * 逻辑删除标记，0代表未删除，1代表已删除，默认为0
     */
    private Boolean deleted;

    /**
     * 创建时间，不允许为空
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间，不允许为空
     */
    private LocalDateTime updateTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
        "userId=" + userId +
        ", email=" + email +
        ", password=" + password +
        ", nickname=" + nickname +
        ", avatar=" + avatar +
        ", deleted=" + deleted +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
