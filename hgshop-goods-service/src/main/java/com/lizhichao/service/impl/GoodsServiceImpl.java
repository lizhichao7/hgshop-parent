package com.lizhichao.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Brand;
import com.lizhichao.bean.Category;
import com.lizhichao.bean.Spu;
import com.lizhichao.bean.SpuVo;
import com.lizhichao.dao.BrandDao;
import com.lizhichao.dao.CategoryDao;
import com.lizhichao.dao.SpuDao;
import com.lizhichao.service.GoodsService;

@Service(interfaceClass=GoodsService.class)
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	CategoryDao catDao;
	
	@Autowired
	SpuDao spuDao;
	
	@Autowired
	BrandDao brandDao;
	

	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.add(category);
	}
 
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.update(category);
	}

	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return catDao.delete(id);
	}

	/**
	 * 
	 */
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return catDao.tree();
	}
	
	// spu的列表
		public PageInfo<Spu> listSpu(int page, SpuVo vo) {
			// TODO Auto-generated method stub
			PageHelper.startPage(page, 10);
			
			return new PageInfo<Spu>(spuDao.list(vo));
		}

		public int addSpu(Spu spu) {
			// TODO Auto-generated method stub
			return spuDao.add(spu);
		}

		public int updateSpu(Spu spu) {
			// TODO Auto-generated method stub
			return spuDao.update(spu);
		}

		public int deleteSpu(int id) {
			// TODO Auto-generated method stub
			return spuDao.delete(id);
		}

		public int deleteSpuBatch(int[] ids) {
			// TODO Auto-generated method stub
			return spuDao.deleteSpuBatch(ids);
		}

		public List<Brand> getAllBrands() {
			// TODO Auto-generated method stub
			return brandDao.listAll();
		}

}
