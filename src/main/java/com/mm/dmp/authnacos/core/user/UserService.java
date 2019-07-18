package com.mm.dmp.authnacos.core.user;

import com.mm.dmp.authnacos.bean.BaseData;
import com.mm.dmp.authnacos.bean.ResultCode;
import com.mm.dmp.authnacos.bean.ResultGenerator;
import com.mm.dmp.authnacos.tool.JwtUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.mm.dmp.authnacos.tool.Constant.TYPE_USER;
import static com.mm.dmp.authnacos.tool.Constant.USER_ID;
import static com.mm.dmp.authnacos.tool.Constant.USER_TYPE;

/**
 * @author wuweifeng wrote on 2018/11/23.
 */
@Component
public class UserService {
    @Resource
    private PtUserManager ptUserManager;
    @Resource
    private JwtUtils jwtUtils;

    public BaseData login(String account, String password) {
        PtUser ptUser = ptUserManager.findByAccount(account);
        if (ptUser == null) {
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.USER_NO_EXIST, "用户不存在");
        }
        if (!ptUser.getPassword().equals(password)) {
            //密码错误
            return ResultGenerator.genFailResult(ResultCode.PASSWORD_ERROR, "密码错误");
        }
        if (ptUser.isDeleteFlag() || 0 != ptUser.getState()) {
            //没有权限
            return ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED, "该用户没有权限");
        }

        Map<String, Object> map = new HashMap<>();
        map.put(USER_ID, ptUser.getId());
        map.put(USER_TYPE, TYPE_USER);
        // Create Twt token
        try {
            String token = jwtUtils.generateToken(map);
            return ResultGenerator.genSuccessResult(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
