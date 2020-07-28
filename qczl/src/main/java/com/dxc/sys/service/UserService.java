package com.dxc.sys.service;

import com.dxc.sys.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User login(User user);
}
