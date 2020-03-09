package com.lizhichao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lizhichao.bean.Brand;

public interface BrandDao {
	/**
	 * 品牌查询
	 * @param firstChar
	 * @param page
	 * @return
	 */
	List<Brand> listBrand( String firstChar); 
	
	
	int addBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Integer id);
	Brand findBrand(Integer id);
	
	/**
	 * 获取所有的品牌
	 * @return
	 */
	@Select("SELECT id,name,first_char as firstChar "
			+ " FROM hg_brand "
			+ "where deleted_flag=0"
			+ " ORDER BY name ")
	List<Brand> listAll();
}
