package com.mm.dmp.authnacos.core.sysuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtSysUserRepository extends JpaRepository<PtSysUser, Long>,
        JpaSpecificationExecutor<PtSysUser> {
    PtSysUser findFirstByAccount(String account);
}
