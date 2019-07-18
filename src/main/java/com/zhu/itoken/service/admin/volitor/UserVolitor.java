package com.zhu.itoken.service.admin.volitor;

import com.google.common.collect.Lists;
import com.zhu.itoken.common.dto.BaseResoult;
import org.thymeleaf.util.StringUtils;

import java.util.List;

public class UserVolitor {

    public static BaseResoult loginVolitor(String userName, String password){
        BaseResoult baseResoult = null;
        List<BaseResoult.Error> errors = Lists.newArrayList();
        if (StringUtils.isEmpty(userName)) {
            BaseResoult.Error error = new BaseResoult.Error();
            error.setFiled("userName");
            error.setMessage("登录名不能为空");
            errors.add(error);
        }
        if (StringUtils.isEmpty(password)) {
            BaseResoult.Error error = new BaseResoult.Error();
            error.setFiled("password");
            error.setMessage("密码不能为空");
            errors.add(error);
        }
        if (StringUtils.isEmpty(password)||StringUtils.isEmpty(userName)) {
            baseResoult.setErrors(errors);
            BaseResoult.notok(errors);
        }
        return baseResoult;
    }
}
