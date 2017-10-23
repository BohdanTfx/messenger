package com.epam.messenger.message.manager.util;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

import com.epam.messenger.common.model.enums.Service;

@Component
public class ServiceURLProvider {

  private static LoadBalancerClient loadBalancerStatic;

  @Autowired
  private LoadBalancerClient loadBalancer;

  @PostConstruct
  public void init() {
    loadBalancerStatic = loadBalancer;
  }

  public static URI getURL(Service service) {
    ServiceInstance instance = loadBalancerStatic.choose(service.getName());
    return instance.getUri();
  }

}
