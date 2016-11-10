package com.command.line.server.factory;

/**
 * wzm location ip 8.8.8.8
 */
public class LocationCommand extends Command {

	@Override
	public String run() throws Exception {
		return this.getLocationClient().location(params);
	}

}
