package com.wzm.zuul.gateway.filter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class LogFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	private AtomicInteger c = new AtomicInteger(0);
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    Long timestamp = new Date().getTime();
	    String inTimestamp = ctx.getZuulRequestHeaders().get("in-timestamp");
	    Long spend = (timestamp - new Long(inTimestamp));
	    logger.info("in-timestamp: {}, out-timestamp: {}, time spend: {}ms", inTimestamp, timestamp.toString(), spend);
	    logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	    
	    ctx.getResponse().setHeader("internal-time-spend", spend.toString() + "ms");
	    logger.info("count: {}", c.getAndIncrement());
	    return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "post";
	}

}
