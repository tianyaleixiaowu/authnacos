package com.mm.dmp.authnacos.core.corp;

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
public class CorpUserService {
    @Resource
    private PtCorpUserManager ptCorpUserManager;
    @Resource
    private JwtUtils jwtUtils;

    public BaseData login(String account, String password) {
        PtCorpUser ptCorpUser = ptCorpUserManager.findByAccount(account);
        if (ptCorpUser == null) {
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.USER_NO_EXIST, "用户不存在");
        }
        if (!ptCorpUser.getPassword().equals(password)) {
            //密码错误
            return ResultGenerator.genFailResult(ResultCode.PASSWORD_ERROR, "密码错误");
        }
        if (ptCorpUser.isDeleteFlag() || 0 != ptCorpUser.getState()) {
            //没有权限
            return ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED, "该用户没有权限");
        }

        Map<String, Object> map = new HashMap<>();
        map.put(USER_ID, ptCorpUser.getId());
        map.put(USER_TYPE, TYPE_CORP);
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
