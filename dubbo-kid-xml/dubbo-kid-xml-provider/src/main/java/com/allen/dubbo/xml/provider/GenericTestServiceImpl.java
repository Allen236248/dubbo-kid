package com.allen.dubbo.xml.provider;

import com.allen.dubbo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GenericTestServiceImpl implements GenericTestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericTestServiceImpl.class);

    @Override
    public String invoke1(String name) {
        LOGGER.info("参数 Name 是：" + name);
        return "参数 Name 是：" + name;
    }

    @Override
    public User findUser(User user) {
        User _user = new User();
        _user.setName(user.getName());
        _user.setEmail("allen9600@163.com");
        return _user;
    }
}
