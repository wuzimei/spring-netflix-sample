package com.command.line.server.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFactory {

	private static String[] seperate(String str) {
		String left = fullMatch("^[^ ]+", str);
		int index = str.indexOf(left);
		String right = str.substring(index + left.length()).trim();
		return new String[]{left, right};
	}
	
	public static Command create(String command) {
		String tmp = command.trim();
		// sample: wzm admin hello
		
		String[] sepr = seperate(tmp);
		String domain = sepr[0];
		sepr = seperate(sepr[1]);
		String function = sepr[0];
		sepr = seperate(sepr[1]);
		String action = sepr[0];
		String params = sepr[1];
		
		Command cmd = null;
		try {
			@SuppressWarnings("rawtypes")
			Class c = Class.forName("com.command.line.server.factory." + function.substring(0, 1).toUpperCase() + function.substring(1) + "Command");
			cmd = (Command) c.newInstance();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		cmd.action = action;
		cmd.params = params;
		cmd.function = function;
		cmd.domain = domain;
		return cmd;
		
	}
	
	public static String fullMatch(String regex, String str) {
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(str);

        List<String> result = new ArrayList<String>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        
        if (result.isEmpty()) {
        	return "";
        } 
        return result.get(0);
    }
}
