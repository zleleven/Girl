package com.imooc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;

@RestController
public class GirlController {
	
	@Autowired
	public GirlRepository girlRepository;
	
	@Autowired
	public GirlService girlService;

	/**
	 * 查询所有
	 * @return
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList(){
		return girlRepository.findAll();
	}
	
	/**
	 * 添加一个
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/girls")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		Result<Girl> result = new Result<Girl>();
		if(bindingResult.hasErrors()) {
			//return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
			return null;
		}
		
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		
		return ResultUtil.success(girlRepository.save(girl));
		
	}
	
	/**
	 * 查询一个
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/{id}")
	public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findById(id);
	}
	
	/**
	 * 查询一个
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
		return girlRepository.findByAge(age);
	}
	
	/**
	 * 更新
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PutMapping(value = "/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id,
							@RequestParam("cupSize") String cupSize,
							@RequestParam("age") Integer age) {
		Girl girl = new Girl(id, cupSize, age);
		return girlRepository.save(girl);
	}
	
	/**
	 * 删除一个
	 * @param id
	 */
	@DeleteMapping(value = "/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.deleteById(id);
	}
	
	/**
	 * 事务
	 */
	@PostMapping(value = "/girls/two")
	public void girlTwo() {
		girlService.insertTwo();
	}
	
	@GetMapping(value = "/girls/getAge/{id}")
	public void getAge(@PathVariable Integer id) throws Exception {
		girlService.getAge(id);
	}
}
