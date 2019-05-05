package com.sh.lrtree.entity;

import java.util.List;

import com.sh.lrtree.struct.LrSortedBuildableTree;
import com.sh.lrtree.struct.LrTree;

public abstract class LrAbstractEntity<T extends LrTree<PK>, PK> implements LrSortedBuildableTree<T, PK>{
	
	private Integer sort;
	
	private Integer level;
	
	private PK parentId;

	private Integer leftValue;
	
	private Integer rightValue;
	
	private List<T> children;
	

	public PK getParentId() {
		return parentId;
	}
	
	public void setParentId(PK parentId) {
		this.parentId = parentId;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public List<T> getChildren() {
		return children;
	}
	
	public void setChildren(List<T> children) {
		this.children = children;
	}
	
	public Integer getLeftValue() {
		return leftValue;
	}
	
	public void setLeftValue(Integer leftValue) {
		this.leftValue = leftValue;
	}
	
	public Integer getRightValue() {
		return rightValue;
	}
	
	public void setRightValue(Integer rightValue) {
		this.rightValue = rightValue;
	}
	
	public boolean isLeaf(){
		return this.getLeftValue() != null && this.getRightValue() != null && this.getRightValue() - this.getLeftValue() == 1;
	}
}
