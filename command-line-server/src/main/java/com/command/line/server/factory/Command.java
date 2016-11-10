package com.command.line.server.factory;

import com.command.line.server.App;
import com.command.line.server.LocationClient;
import com.command.line.server.WordSegmentClient;

public abstract class Command {

	public String params;
	public String domain;
	public String action;
	public String function;
	
	protected WordSegmentClient getWordSegmentClient() {
		return (WordSegmentClient) App.getApplicationContext().getBean("com.command.line.server.WordSegmentClient");
	}
	
	protected LocationClient getLocationClient() {
		return (LocationClient) App.getApplicationContext().getBean("com.command.line.server.LocationClient");
	}
	
	public String wrapRun() throws Exception {
		System.out.println("domain: " + domain);
		System.out.println("function: " + function);
		System.out.println("action: " + action);
		System.out.println("params: " + params);
		return run();
	}
	
	/**
	 * every subclass should implement run() method.
	 * @return
	 */
	protected abstract String run() throws Exception;
}
