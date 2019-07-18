package com.mm.dmp.authnacos.core.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mm.dmp.authnacos.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2017/10/25.
 * 各项目owner账号
 */
@Entity
@Table(indexes = {@Index(name = "account", columnList =
        "account"), @Index(name = "projectGroupId", columnList =
        "projectGroupId")})
public class PtUser extends BaseDeleteEntity {
    /**
     * 账号
     */
    private String account;
    /**
     * 密码（md5加密小写）
     */
    @JsonIgnore
    private String password;
    /**
     * 项目groupId
     */
    private Long projectGroupId;
    /**
     * 状态，0是正常
     */
    private Byte state;

    @Override
    public String toString() {
        return "PtUser{" +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", projectGroupId=" + projectGroupId +
                ", state=" + state +
                '}';
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getProjectGroupId() {
        return projectGroupId;
    }

    public void setProjectGroupId(Long projectGroupId) {
        this.projectGroupId = projectGroupId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
