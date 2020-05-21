package com.allen.dubbo.xml.provider;

import com.allen.dubbo.domain.User;

public interface GenericTestService {

    String invoke1(String name);

    User findUser(User user);

}
