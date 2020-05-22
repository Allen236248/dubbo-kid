package com.allen.dubbo.xml.provider;

import com.allen.dubbo.iface.CallbackListener;
import com.allen.dubbo.iface.CallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CallbackServiceImpl implements CallbackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackServiceImpl.class);

    private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<String, CallbackListener>();

    public CallbackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        for(Map.Entry<String, CallbackListener> entry : listeners.entrySet()) {
                            String key = entry.getKey();
                            entry.getValue().changed(getChanged("Schedule:", key));
                        }
                        Thread.sleep(5000);//定时触发变更通知
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    public void addListener(String key, CallbackListener listener) {
        listeners.put(key, listener);
        listener.changed(getChanged("Invoke:", key));
    }

    private String getChanged(String prefix, String key) {
        return prefix + "Changed: " + key + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
