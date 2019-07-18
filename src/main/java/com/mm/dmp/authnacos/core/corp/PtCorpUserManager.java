package com.mm.dmp.authnacos.core.corp;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author wuweifeng wrote on 2017/10/26.
 */
@Service
public class PtCorpUserManager {
    @Resource
    private PtCorpUserRepository ptCorpUserRepository;

    /**
     * 根据account查询User
     *
     * @param account
     *         账号名
     * @return 用户
     */
    public PtCorpUser findByAccount(String account) {
        return ptCorpUserRepository.findFirstByAccount(account);
    }


}
