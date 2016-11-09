package com.wzm.service.word.segment;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.lionsoul.jcseg.tokenizer.ASegment;
import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.DictionaryFactory;
import org.lionsoul.jcseg.tokenizer.core.IWord;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;
import org.lionsoul.jcseg.tokenizer.core.SegmentFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.core.api.IWordSegment;

@RestController
public class WordSegmentController implements IWordSegment{

	@Override
	public List<String> wordSegment(@RequestBody String sentence) throws Exception {
		System.out.println(sentence);
		JcsegTaskConfig config = new JcsegTaskConfig(true);
		ADictionary dic = DictionaryFactory.createSingletonDictionary(config);
		ASegment seg = (ASegment) SegmentFactory.createJcseg(
			    JcsegTaskConfig.COMPLEX_MODE, 
			    new Object[]{new StringReader(sentence), config, dic}
			);
		List<String> result = new ArrayList<String>();
		IWord word = null;
		while ( (word = seg.next()) != null ) {
		    result.add(word.getValue());
		}
		return result;
	}

}
