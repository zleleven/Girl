package com.imooc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.Exception.GirlException;
import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;

import enums.ResultEnum;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	
	public void insertTwo() {
		Girl girlA = new Girl("F", 23);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl("CBBBB", 22);
		girlRepository.save(girlB);
	}
	
	public void getAge(Integer id) throws Exception {
		Optional<Girl> girl = girlRepository.findById(id);
		Integer age = girl.get().getAge();
		if(age < 10) {
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age > 10 && age < 16) {
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}
	
	/**
	 * 通过id查询一个女生的信息
	 * @param id
	 * @return
	 */
	public Girl fineOne(Integer id) {
		Optional<Girl> girl = girlRepository.findById(id);
		return girl.get();
	}
	
}
