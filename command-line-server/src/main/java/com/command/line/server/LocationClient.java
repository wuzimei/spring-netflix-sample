package com.command.line.server;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.service.core.api.ILocation;

@FeignClient(name = "IP-LOCATION-SERVER")
public interface LocationClient extends ILocation {

}