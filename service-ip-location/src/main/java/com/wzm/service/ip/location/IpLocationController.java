package com.wzm.service.ip.location;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.core.api.ILocation;

@RestController
public class IpLocationController implements ILocation{

	@Override
	@ResponseBody
	public String location(@RequestParam("ip") String ip) throws Exception {
		return StringUtils.arrayToDelimitedString(IP.find(ip), ",");
	}

	
}
