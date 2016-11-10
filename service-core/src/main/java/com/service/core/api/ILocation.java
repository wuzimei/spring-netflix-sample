package com.service.core.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface ILocation {

	/**
	 * given an ip, return the location of the ip.
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value ="/v1/location")
	String location(@RequestParam("ip") String ip) throws Exception;
}
