package com.mm.dmp.authnacos.core.sysuser;

import com.mm.dmp.authnacos.base.BaseDeleteEntity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2017/10/25.
 * 系统用户
 */
@Entity
@Table(indexes = {@Index(name = "account", columnList = "account")})
public class PtSysUser extends BaseDeleteEntity {
    /**
     * 用户名称
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色id
     */
    private Long roleId;
    private Byte state;

    @Override
    public String toString() {
        return "PtSysUser{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", state=" + state +
                '}';
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
