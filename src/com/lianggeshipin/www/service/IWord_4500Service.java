package com.lianggeshipin.www.service;

import java.util.List;

import com.lianggeshipin.www.model.Word_4500;

public interface IWord_4500Service {
	public int add(Word_4500 word);
	
	public List<Word_4500> getPage(Integer pageNum);
}
