package com.dxc.sys.service.impl;

import com.dxc.sys.dao.UserDao;
import com.dxc.sys.entity.User;
import com.dxc.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;


public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        //明文123456
        //生成密文
        //使用的是
        //pwd对应的是name属性为pwd  ,进行了传参,这里使用了name属性传参,注意id属性在这里不能作传参的
        //这里使用的是Java自身集成的MD5加密计数,因为我们需要的最终结果是一个字符串(User中的属性pwd是String类型),因此使用md5DigestAsHex方法(需要传递一个byte类型的参数)
        String pwd = DigestUtils.md5DigestAsHex(user.getPwd().getBytes());
        System.out.println(pwd);
        user.setPwd(pwd);
        return userDao.login(user);
    }
}
