package com.sh.lrtree.entity;

import com.sh.lrtree.struct.LrTree;

public class LrBaseStringIdEntity<T extends LrTree<String>> extends LrAbstractEntity<T, String>{
	
	private String id;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
