package com.lizhichao.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Brand;
import com.lizhichao.dao.BrandDao;
import com.lizhichao.service.BrandService;

@Service(interfaceClass=BrandService.class)
public class BrandServiceImpl implements BrandService{
	@Autowired
	BrandDao brandDao;

	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		
		return brandDao.addBrand(brand);
	}
	
	public Brand findBrand(Integer id) {
		return brandDao.findBrand(id);
	}

	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.updateBrand(brand);
	}

	public int deleteBrand(Integer id) {
		// TODO Auto-generated method stub
		return brandDao.deleteBrand(id);
	}

	public PageInfo<Brand> listBrand(String firstChar, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 3);
		
		return new PageInfo<Brand>(brandDao.listBrand(firstChar));
	}

	public List<Brand> getAllBrands() {
		// TODO Auto-generated method stub
		return brandDao.listAll();
	}
}
