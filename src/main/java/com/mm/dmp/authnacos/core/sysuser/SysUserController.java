package com.mm.dmp.authnacos.core.sysuser;

import com.mm.dmp.authnacos.bean.BaseData;
import com.mm.dmp.authnacos.bean.ResultGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/23.
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @PostMapping("/login")
    public BaseData delete(String account, String password) {
        return ResultGenerator.genSuccessResult(sysUserService.login(account, password));
    }

}
