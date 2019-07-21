package com.zhu.itoken.service.admin.service;


import com.zhu.itoken.common.domain.User;

public interface UserService {
    User getUserById(Integer id);
    void insertUser(User user);
}
