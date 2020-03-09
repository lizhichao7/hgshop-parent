package com.lizhichao.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lizhichao.bean.Brand;
import com.lizhichao.service.BrandService;


/**
 * 品牌管理
 * @author 李志超
 *
 */
@Controller
@RequestMapping("brand")
public class BrandController {
	@Reference
	BrandService brandService;
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="")String firstChar) {
		PageInfo<Brand> pageInfo = brandService.listBrand(firstChar, page);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("firstChar", firstChar);
		
		return "brand/list";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Brand brand) {
		System.out.println("brand"+brand);
		
		return brandService.addBrand(brand)>0?"success":"false";
		
	}
	
	@RequestMapping("getBrand")
	@ResponseBody
	public Brand getBrand(HttpServletRequest request, int id) {
		return brandService.findBrand(id);

	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(HttpServletRequest request,Brand brand){
		System.out.println(brand+"brand");
		return brandService.updateBrand(brand)>0?"success":"false";
	}
	
	@RequestMapping("delBrand")
	@ResponseBody
	public Object delBrand(int id){
		return brandService.deleteBrand(id)>0?"success":"false";
		
	}
}
