package com.mm.dmp.authnacos.core.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtUserRepository extends JpaRepository<PtUser, Long>,
        JpaSpecificationExecutor<PtUser> {
    PtUser findFirstByAccount(String account);

    List<PtUser> findByAccountLike(String account);

    List<PtUser> findByNameLike(String name);

}
