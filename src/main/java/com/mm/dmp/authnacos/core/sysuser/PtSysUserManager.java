package com.mm.dmp.authnacos.core.sysuser;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author wuweifeng wrote on 2017/10/26.
 */
@Service
public class PtSysUserManager {
    @Resource
    private PtSysUserRepository userRepository;

    /**
     * 根据account查询User
     *
     * @param account
     *         账号名
     * @return 用户
     */
    public PtSysUser findByAccount(String account) {
        return userRepository.findFirstByAccount(account);
    }

}
