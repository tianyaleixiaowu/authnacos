package com.mm.dmp.authnacos.core.corp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mm.dmp.authnacos.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2017/10/25.
 * 职场用户表
 */
@Entity
@Table(indexes = {@Index(name = "account", columnList =
        "account"), @Index(name = "corpId", columnList =
        "corpId")})
public class PtCorpUser extends BaseDeleteEntity {
    /**
     * 用户名称
     */
    private String name;
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
    private Long corpId;
    /**
     * 状态，0是正常
     */
    private Byte state;

    @Override
    public String toString() {
        return "PtCorpUser{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", corpId=" + corpId +
                ", state=" + state +
                '}';
    }

    public Long getCorpId() {
        return corpId;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
