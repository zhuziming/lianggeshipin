package com.lianggeshipin.www.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lianggeshipin.www.dao.IWord4500Dao;
import com.lianggeshipin.www.model.Word_4500;
import com.lianggeshipin.www.service.IWord_4500Service;

@Service("word_4500ServiceImpl")
public class Word_4500ServiceImpl implements IWord_4500Service {

	@Resource
	private IWord4500Dao word4500Dao;
	
	public static Map<Integer, List<Word_4500>> map = new HashMap<Integer, List<Word_4500>>();

	@Override
	public int add(Word_4500 word) {
		
		return word4500Dao.add(word);
	}

	@Override
	public List<Word_4500> getPage(Integer pageNum) {
		if(map.get(pageNum)==null){
			map.put(pageNum, word4500Dao.getPage(pageNum));
		}
		return map.get(pageNum);
	}

}
