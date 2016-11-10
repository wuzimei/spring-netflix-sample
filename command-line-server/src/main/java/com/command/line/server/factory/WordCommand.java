package com.command.line.server.factory;

import java.util.List;

/**
 * wzm word segment xxxx
 */
public class WordCommand extends Command {

	@Override
	public String run() throws Exception {
		List<String> list = this.getWordSegmentClient().wordSegment(params);
		
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			if (!str.equals(",") && !str.equals("，")) {
				sb.append(str + " ");
			}
		}
		return sb.toString();
	}

}
