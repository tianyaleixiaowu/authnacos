package com.mm.dmp.authnacos.core.user;

import com.mm.dmp.authnacos.bean.BaseData;
import com.mm.dmp.authnacos.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/23.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public BaseData delete(String account, String password) {
        return ResultGenerator.genSuccessResult(userService.login(account, password));
    }

}
