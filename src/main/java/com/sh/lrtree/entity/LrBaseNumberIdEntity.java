package com.sh.lrtree.entity;

import com.sh.lrtree.struct.LrTree;

public class LrBaseNumberIdEntity<T extends LrTree<Long>> extends LrAbstractEntity<T, Long>{
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
