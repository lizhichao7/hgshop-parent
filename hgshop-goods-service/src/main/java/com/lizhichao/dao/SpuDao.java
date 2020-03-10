package com.lizhichao.dao;

import java.util.List;

import com.lizhichao.bean.Spu;
import com.lizhichao.bean.SpuVo;

public interface SpuDao {
	int add(Spu spu);

	int deleteSpuBatch(int[] ids);

	int update(Spu spu);

	List<Spu> list(SpuVo vo);

	int delete(int id);
	
	Spu findById(int id);
}
