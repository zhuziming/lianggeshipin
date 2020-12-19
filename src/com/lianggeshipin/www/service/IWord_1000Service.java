package com.lianggeshipin.www.service;

import java.util.List;

import com.lianggeshipin.www.model.Word_1000;

public interface IWord_1000Service {
	public int add(Word_1000 word);
	
	public List<Word_1000> getPage(Integer pageNum);
}
