package com.allen.dubbo.xml.provider;

import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛化实现主要用于服务者没有 API 接口实现及模型类元的情况。
 * 此例中只知道接口：com.allen.dubbo.iface.BarService，但是没有实现
 */
@Service
public class GenericServiceImpl implements GenericService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if("invoke1".equals(method)) {
            return "返回值：" + args[0];
        } else if("findUser".equals(method)) {
            //参数及返回值中的所有POJO均用Map表示
            Map<String, Object> result = new HashMap<>();
            Map<String, Object> user = (Map<String, Object>) args[0];
            result.put("name", user.get("name"));
            result.put("email", "heshiyu2008@163.com");
            return result;
        }
        return null;
    }
}
