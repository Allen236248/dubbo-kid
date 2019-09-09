package com.allen.dubbo.xml.provider;

import com.alibaba.fastjson.JSON;
import com.allen.dubbo.domain.User;
import com.allen.dubbo.iface.RestService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import java.util.Map;

@Service
@Path("/rest")
public class RestServiceImpl implements RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestServiceImpl.class);

    @GET
    @Path("/hi")
    public String sayHi(@RequestParam("name") String name) {
        String msg = "";
        if(RpcContext.getContext().getRequest() instanceof HttpServletRequest) {
            msg = "RpcContext.getContext().getRequest() instanceof HttpServletRequest";
        }
        LOGGER.info("Hi " + name + ", this is rest demo and " + msg);
        return "Hi " + name + ", this is rest demo and " + msg;
    }

    @POST
    @Path("/add_attach")
    @Consumes(ContentType.APPLICATION_JSON_UTF_8)
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public User setUserEmail(User user) {
        user.setEmail("allen9600@163.com");
        LOGGER.info(JSON.toJSONString(user));
        return user;
    }
}
