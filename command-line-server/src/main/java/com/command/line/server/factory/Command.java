package com.command.line.server.factory;

public abstract class Command {

	public String params;
	public String domain;
	public String action;
	public String function;
	
	
	
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
