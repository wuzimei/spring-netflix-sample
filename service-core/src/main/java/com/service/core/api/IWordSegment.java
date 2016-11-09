package com.service.core.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IWordSegment {

	@RequestMapping(method = RequestMethod.POST, value ="/v1/word/segment")
	List<String> wordSegment(String sentence) throws Exception;
}
