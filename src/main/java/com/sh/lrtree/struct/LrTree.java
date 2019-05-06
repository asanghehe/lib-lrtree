package com.sh.lrtree.struct;

import java.util.List;

/**
 * 左右值树   基本结构
 * @author asang
 *
 */
public interface LrTree<PK> {
	
	public PK getId();
	
	public PK getParentId();
	
	public void setLeftValue(Integer left);
	
	public void setRightValue(Integer right);

	public Integer getLevel();

	public void setLevel(Integer level);
	
	public boolean isLeaf();
	
	public <T extends LrTree<PK>> List<T> getChildren();
}
