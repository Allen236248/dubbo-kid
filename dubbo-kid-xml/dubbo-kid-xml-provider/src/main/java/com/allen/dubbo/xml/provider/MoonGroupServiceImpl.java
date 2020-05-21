package com.allen.dubbo.xml.provider;

import com.allen.dubbo.iface.GroupService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MoonGroupServiceImpl implements GroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoonGroupServiceImpl.class);

    public String groupName() {
        LOGGER.info("" + RpcContext.getContext().getAttachment("aaa"));
        LOGGER.info("Group Name is moon");
        return "Group Name is moon";
    }
}
