package com.mm.dmp.authnacos.core.corp;

import com.mm.dmp.authnacos.bean.BaseData;
import com.mm.dmp.authnacos.bean.ResultGenerator;
import com.mm.dmp.authnacos.core.sysuser.SysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/23.
 */
@RestController
@RequestMapping("/corpUser")
public class CorpUserController {
    @Resource
    private CorpUserService corpUserService;

    @PostMapping("/login")
    public BaseData delete(String account, String password) {
        return ResultGenerator.genSuccessResult(corpUserService.login(account, password));
    }

}
