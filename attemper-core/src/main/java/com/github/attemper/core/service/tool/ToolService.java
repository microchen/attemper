package com.github.attemper.core.service.tool;

import com.github.attemper.common.constant.CommonConstants;
import com.github.attemper.common.enums.ArgType;
import com.github.attemper.common.enums.PredefinedDateArgType;
import com.github.attemper.common.enums.UriType;
import com.github.attemper.common.exception.RTException;
import com.github.attemper.config.base.property.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.*;

@Slf4j
@Service
public class ToolService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private AppProperties appProperties;

    public String[] listTimeZone() {
        return TimeZone.getAvailableIDs();
    }

    public Boolean ping(String uri, Integer type) {
        if (uri == null) {
            log.error("uri is null");
            return false;
        }
        try {
            if (log.isDebugEnabled()) {
                log.debug(uri);
            }
            uri = uri.replace("https://", "").replace("http://", "");
            if (type == UriType.DiscoveryClient.getType()) {
                if (log.isDebugEnabled()) {
                    log.debug("discovery client");
                }
                List<ServiceInstance> instances = discoveryClient.getInstances(uri);
                if (instances.isEmpty()) {
                    throw new RTException(800);
                }
                instances.forEach(item -> ping(item.getUri().toString(), UriType.IpWithPort.getType()));
            } else if (type == UriType.IpWithPort.getType()) {
                if (log.isDebugEnabled()) {
                    log.debug("ip:port");
                }
                String[] arr = uri.split(":");
                SocketAddress socketAddr = new InetSocketAddress(arr[0], Integer.parseInt(arr[1]));
                new Socket().connect(socketAddr, 5000);
            } else if (type == UriType.DomainName.getType()) {
                if (log.isDebugEnabled()) {
                    log.debug("domain");
                }
                InetAddress.getByName(uri).isReachable(5000);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public List<ServiceInstance> listExecutorService() {
        return listService(appProperties.getExecutor().getName());
    }

    private List<ServiceInstance> listService(String serviceId) {
        return discoveryClient.getInstances(serviceId);
    }

    public Date getCurrentTime() {
        return new Date();
    }

    public List<Map<String, Object>> listArgType() {
        List<Map<String, Object>> list = new ArrayList<>(20);
        for (ArgType type : ArgType.values()) {
            Map<String, Object> map = new HashMap<>(2);
            map.put(CommonConstants.label, type.getName());
            map.put(CommonConstants.value, type.getValue());
            list.add(map);
        }
        return list;
    }

    public List<String> listTradeDateUnit() {
        List<String> values = new ArrayList<>(10);
        for (PredefinedDateArgType type : PredefinedDateArgType.values()) {
            values.add(type.getValue());
        }
        return values;
    }
}
