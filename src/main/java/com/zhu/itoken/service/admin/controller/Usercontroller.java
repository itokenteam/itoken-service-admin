package com.zhu.itoken.service.admin.controller;

import com.zhu.itoken.common.domain.User;
import com.zhu.itoken.common.dto.BaseResoult;
import com.zhu.itoken.service.admin.service.UserService;
import com.zhu.itoken.service.admin.volitor.UserVolitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {
    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public void addUser(){
        userService.insertUser(new User());
    }

    @RequestMapping("/get")
    public BaseResoult login(@RequestParam(value="userName") String userName, @RequestParam(value="password") String password){
        if (UserVolitor.loginVolitor(userName, password) != null) {
            return UserVolitor.loginVolitor(userName, password);
        }
        return BaseResoult.ok(userService.getUserById(1));
    }
}
