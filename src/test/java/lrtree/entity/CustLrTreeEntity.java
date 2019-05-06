package lrtree.entity;

import java.util.List;

import com.sh.lrtree.struct.LrSortedBuildableTree;

/**
 * 自定义 实现树接口 的实体类， 可被工具构建/扁平化的实体
 * 此用法主要 用于 自定义实体类已经有 继承的父类，无法再继承 库提供的基类情况
 * @author asang
 *
 */
public class CustLrTreeEntity implements LrSortedBuildableTree<CustLrTreeEntity, Long> {
	
	private Long id;
	
	private Integer sort;
	
	private Integer level;
	
	private Long parentId;

	private Integer leftValue;
	
	private Integer rightValue;
	
	private List<CustLrTreeEntity> children;
	
	private String otherField;
	
	public String getOtherField() {
		return otherField;
	}
	
	public void setOtherField(String otherField) {
		this.otherField = otherField;
	}
	
	public void setChildren(List<CustLrTreeEntity> list) {
		this.children = list;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public void setLeftValue(Integer left) {
		this.leftValue = left;
	}

	public Integer getLeftValue() {
		return leftValue;
	}
	
	public void setRightValue(Integer right) {
		this.rightValue = right;
	}
	
	public Integer getRightValue() {
		return rightValue;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<CustLrTreeEntity> getChildren() {
		return this.children;
	}

	public Integer getSort() {
		return this.sort;
	}
}
