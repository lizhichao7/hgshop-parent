package com.lizhichao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Brand;
import com.lizhichao.bean.Category;
import com.lizhichao.bean.Sku;
import com.lizhichao.bean.Spu;
import com.lizhichao.bean.SpuVo;
/**
 * Dubbo 服务接口函数比要有非Void 的返回值
 * @author 李志超
 *
 */
public interface GoodsService {
	 
	
	
	int addCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Category> listCategory( String firstChar,int page);
	List<Brand> getAllBrands( );
	/**
	 * 以树的形式显示列表
	 * @return
	 */
	List<Category> treeCategory();
	
	// spu的管理
	PageInfo<Spu>  listSpu(int page,SpuVo vo);
	int addSpu(Spu spu);
	int updateSpu(Spu spu);
	int deleteSpu(int id);
	Spu getSpu(int id);
	int deleteSpuBatch(int[] id);
	
	// sku的管理
	PageInfo<Sku>  listSku(int page,Sku sku);
	int addSku(Sku sku);
	Sku getSku(int id);//获取详情
	int updateSku(Sku sku);
	int deleteSku(int id);
	int deleteSkuBatch(int[] id);
		
		
}
