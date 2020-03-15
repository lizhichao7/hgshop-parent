package com.lizhichao.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Brand;
import com.lizhichao.bean.Category;
import com.lizhichao.bean.Sku;
import com.lizhichao.bean.SpecOption;
import com.lizhichao.bean.Spu;
import com.lizhichao.bean.SpuEsVo;
import com.lizhichao.bean.SpuVo;
import com.lizhichao.dao.BrandDao;
import com.lizhichao.dao.CategoryDao;
import com.lizhichao.dao.SkuDao;
import com.lizhichao.dao.SpuDao;
import com.lizhichao.service.GoodsService;
import com.lizhichao.utils.ElSearchUtil;

@Service(interfaceClass=GoodsService.class)
public class GoodsServiceImpl implements GoodsService{
	
	// 工具类
	@Autowired
	ElSearchUtil<SpuEsVo> elSearchUtils;
	
	@Autowired
	CategoryDao catDao;
	
	@Autowired
	SpuDao spuDao;
	
	@Autowired
	KafkaTemplate<String, String> kafakTemplate;
	
	@Autowired
	BrandDao brandDao;
	
	@Autowired
	SkuDao skuDao;
	

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
		int cnt =  spuDao.add(spu);
		//kafaTemplate.send("MyAddSpu", "spuId", cnt+"");
		
		// 将该数据收集到搜搜引擎当中
		Spu newSpu = spuDao.findById(spu.getId());
		SpuEsVo spuEsVo = new SpuEsVo(newSpu);
		System.out.println(" >>>>>>>>>>> spuEsVo is " + spuEsVo);
		elSearchUtils.saveObject(spu.getId().toString(), spuEsVo);
		
		// 使用kafak 去发送消息  把商品id 发送到主题MyAddSpu 上。
		kafakTemplate.send("MyAddSpu", "addspu",spu.getId().toString() );
		
		
		return cnt;
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
	
	public PageInfo<Sku> listSku(int page, Sku sku) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		return new PageInfo<Sku>(skuDao.list(sku));
	}

	public int addSku(Sku sku) {
		// TODO Auto-generated method stub
		//先加主表
		int cnt = skuDao.addSku(sku);
		List<SpecOption> specs = sku.getSpecs();
		for (SpecOption specOption : specs) {
			cnt += skuDao.addSkuSpec(sku.getId(),specOption);
		}
		
		return cnt;
	}

	public Sku getSku(int id) {
		// TODO Auto-generated method stub
		return skuDao.get(id);
	}

	public int updateSku(Sku sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteSku(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteSkuBatch(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Spu getSpu(int id) {
		// TODO Auto-generated method stub
		return spuDao.findById(id);
	}
	
	public List<Sku> listSkuBySpu(int spuId) {
		// TODO Auto-generated method stub
		return skuDao.listBySpu(spuId);
	}


}
