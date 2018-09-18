package com.idle.app.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Item")
public class Item implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	@Column(name="name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
}
