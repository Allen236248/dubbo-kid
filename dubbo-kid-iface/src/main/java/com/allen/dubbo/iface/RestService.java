package com.allen.dubbo.iface;

import com.allen.dubbo.domain.User;

public interface RestService {

    String sayHi(String name);

    User setUserEmail(User user);

}
