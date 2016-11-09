package com.command.line.server.factory;

import java.util.List;

public class WordCommand extends Command {

	@Override
	public String run() throws Exception {
		List<String> list = CommandFactory.getWordSegmentClient().wordSegment(params);
		
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			if (!str.equals(",") && !str.equals("，")) {
				sb.append(str + " ");
			}
		}
		return sb.toString();
	}

}
