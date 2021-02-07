package com.lianggeshipin.www.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lianggeshipin.www.dao.IWord1000Dao;
import com.lianggeshipin.www.model.Word_1000;
import com.lianggeshipin.www.model.Word_4500;
import com.lianggeshipin.www.service.IWord_1000Service;

@Service("word_1000ServiceImpl")
public class Word_1000ServiceImpl implements IWord_1000Service {

	@Resource
	private IWord1000Dao word1000Dao;

	public static Map<Integer, List<Word_1000>> map = new HashMap<Integer, List<Word_1000>>();
	
	@Override
	public int add(Word_1000 word) {
		
		return word1000Dao.add(word);
	}

	@Override
	public List<Word_1000> getPage(Integer pageNum) {
		if(map.get(pageNum)==null){
			map.put(pageNum, word1000Dao.getPage(pageNum));
		}
		return map.get(pageNum);
	}

}
