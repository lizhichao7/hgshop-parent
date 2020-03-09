package com.lizhichao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Brand;

public interface BrandService {
	int addBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Integer id);
	Brand findBrand(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Brand> listBrand( String firstChar,int page);
	
}
