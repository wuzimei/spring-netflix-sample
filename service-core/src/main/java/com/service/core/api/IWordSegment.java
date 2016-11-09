package com.service.core.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IWordSegment {

	/**
	 * given a sentence, return lists of words in the sentence.
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value ="/v1/word/segment")
	List<String> wordSegment(String sentence) throws Exception;
}
