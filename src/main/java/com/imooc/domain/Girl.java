package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;


@Entity
public class Girl {
	@Id
	@GeneratedValue
	private Integer id;
	private String cupSize;
	
	@Min(value = 5, message = "未成年少女禁止入内")
	private Integer age;
	@Override
	public String toString() {
		return "Girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public Girl(String cupSize, Integer age) {
		this.cupSize = cupSize;
		this.age = age;
	}
	public Girl(Integer id, String cupSize, Integer age) {
		this.id = id;
		this.cupSize = cupSize;
		this.age = age;
	}
	public Girl() {
		super();
	}
	
	
}
