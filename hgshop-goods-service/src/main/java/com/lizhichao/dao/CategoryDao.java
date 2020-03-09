package com.lizhichao.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Brand;
import com.lizhichao.bean.Category;
/**
 * 
 * @author 李志超
 *
 */
public interface CategoryDao {
	List<Category> tree();
	
	int add(Category category);

	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(Integer id);

	/**
	 * 修改
	 * @param category
	 * @return
	 */
	int update(Category category);
	
	
}
