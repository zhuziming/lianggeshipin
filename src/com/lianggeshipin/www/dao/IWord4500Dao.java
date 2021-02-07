package com.lianggeshipin.www.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lianggeshipin.www.model.Word_4500;

public interface IWord4500Dao {
	/**
	 * @description 添加一个数据
	 * @author zhuziming
	 * @time 2020年12月16日 下午2:24:33
	 * @param word
	 * @return
	 */
	public int add(Word_4500 word);
	/**
	 * @description 查询一页的数据
	 * @author zhuziming
	 * @time 2020年12月16日 下午2:24:47
	 * @param i 第几页
	 * @return
	 */
	public List<Word_4500> getPage(@Param("page") int page);
	
	public int up(Word_4500 word);
	
	
}
