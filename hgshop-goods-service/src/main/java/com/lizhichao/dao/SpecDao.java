package com.lizhichao.dao;

import java.util.List;

import com.lizhichao.bean.Spec;
import com.lizhichao.bean.SpecOption;
/**
 * 
 * @author 李志超
 *
 */
public interface SpecDao {
	List<Spec> list( String name);

	int addSpec(Spec spec);

	int addOption(SpecOption specOption);

	int updateSpec(Spec spec);

	int deleteSpecOtions(int id);

	int deleteSpec(int id);

	Spec get(int id);

	int deleteSpecOtionsBatch(int[] ids);

	int deleteSpecBatch(int[] ids);
	
	List<Spec> listAll();

}
