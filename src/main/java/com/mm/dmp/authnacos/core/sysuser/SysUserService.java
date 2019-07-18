package com.mm.dmp.authnacos.core.sysuser;

import com.mm.dmp.authnacos.bean.BaseData;
import com.mm.dmp.authnacos.bean.ResultCode;
import com.mm.dmp.authnacos.bean.ResultGenerator;
import com.mm.dmp.authnacos.tool.JwtUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.mm.dmp.authnacos.tool.Constant.*;

/**
 * @author wuweifeng wrote on 2019/5/6.
 */
@Service
public class SysUserService {
    @Resource
    private PtSysUserManager ptSysUserManager;
    @Resource
    private JwtUtils jwtUtils;

    public BaseData login(String account, String password) {
        PtSysUser ptSysUser = ptSysUserManager.findByAccount(account);
        if (ptSysUser == null) {
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.USER_NO_EXIST, "用户不存在");
        }
        if (!ptSysUser.getPassword().equals(password)) {
            //密码错误
            return ResultGenerator.genFailResult(ResultCode.PASSWORD_ERROR, "密码错误");
        }
        if (ptSysUser.isDeleteFlag() || 0 != ptSysUser.getState()) {
            //没有权限
            return ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED, "该用户没有权限");
        }

        Map<String, Object> map = new HashMap<>();
        map.put(USER_ID, ptSysUser.getId());
        map.put(USER_TYPE, TYPE_SYS);
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
