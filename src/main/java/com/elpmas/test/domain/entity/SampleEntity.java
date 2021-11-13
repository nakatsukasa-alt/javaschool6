package com.elpmas.test.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sample")
public class SampleEntity {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="string")
	private String string;
	
	//idゲッター
	public int getId() {
		return id;
	}
	
	//idセッター
	public void setId(int id) {
		this.id=id;
	}
	
	//stringゲッター
	public String getString() {
		return string;
	}
	
	//stringセッター
	public void setString(String string) {
		this.string=string;
	}
}
