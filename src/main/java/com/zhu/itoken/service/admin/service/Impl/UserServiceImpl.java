package com.zhu.itoken.service.admin.service.Impl;

import com.zhu.itoken.common.domain.User;
import com.zhu.itoken.service.admin.mapper.UserMapper;
import com.zhu.itoken.service.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void insertUser(User user) {
        user.setPassword("123456");
        user.setAddress(UUID.randomUUID().toString());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insetUser(user);
    }
}
