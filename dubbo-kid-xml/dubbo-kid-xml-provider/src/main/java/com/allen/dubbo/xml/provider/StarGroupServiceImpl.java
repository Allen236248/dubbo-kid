package com.allen.dubbo.xml.provider;

import com.allen.dubbo.iface.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StarGroupServiceImpl implements GroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarGroupServiceImpl.class);

    public String groupName() {
        LOGGER.info("Group Name is star");
        return "Group Name is star";
    }
}
