package com.allen.dubbo.iface;

import com.allen.dubbo.domain.User;

public interface BarService {

    String invoke1(String name);

    User findUser(User user);

}
