package com.command.line.server.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;

import com.command.line.server.WordSegmentClient;

public class CommandFactory {

	private static ApplicationContext ac;
	
	public static void setAc(ApplicationContext applicationContext) {
		ac = applicationContext;
	}
	
	public static WordSegmentClient getWordSegmentClient() {
		return (WordSegmentClient)ac.getBean("com.command.line.server.WordSegmentClient");
	}
	
	public static Command create(String command) {
		String tmp = command.trim();
		// sample: wzm admin hello
		
		String domain = fullMatch("^[^ ]+", tmp);
		int index = tmp.indexOf(domain);
		tmp = tmp.substring(index + domain.length()).trim();
		String function = fullMatch("^[^ ]+", tmp);
		index = tmp.indexOf(function);
		tmp = tmp.substring(index + function.length()).trim();
		String action = fullMatch("^[^ ]+", tmp);
		index = tmp.indexOf(action);
		tmp = tmp.substring(index + action.length()).trim();
		
		Command cmd = null;
		try {
			Class c = Class.forName("com.command.line.server.factory." + function.substring(0, 1).toUpperCase() + function.substring(1) + "Command");
			cmd = (Command) c.newInstance();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		cmd.action = action;
		cmd.params = tmp;
		cmd.function = function;
		cmd.domain = domain;
		return cmd;
		/*
		if (action.equals("admin")) {
			return new AdminCommand(domain, function, action, tmp);
		} else if (action.equals("word")) {
			return new WordCommand(domain, function, action, tmp);
		} else {
			return null;
		}*/
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
