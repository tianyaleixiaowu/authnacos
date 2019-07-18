package com.mm.dmp.authnacos.core.corp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtCorpUserRepository extends JpaRepository<PtCorpUser, Long>,
        JpaSpecificationExecutor<PtCorpUser> {
    PtCorpUser findFirstByAccount(String account);

    List<PtCorpUser> findByAccountLike(String account);

    List<PtCorpUser> findByNameLike(String name);

}
