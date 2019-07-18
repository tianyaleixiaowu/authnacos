package com.mm.dmp.authnacos.core.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author wuweifeng wrote on 2017/10/26.
 */
@Service
public class PtUserManager {
    @Resource
    private PtUserRepository ptUserRepository;


    /**
     * 根据account查询User
     *
     * @param account
     *         账号名
     * @return 用户
     */
    public PtUser findByAccount(String account) {
        return ptUserRepository.findFirstByAccount(account);
    }

}
