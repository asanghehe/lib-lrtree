package com.sh.lrtree.struct;

import java.util.List;

/**
 * 可提供 给TreeUtils 经行构建树的接口
 * @author asang
 *
 */
public interface LrBuildableTree<T extends LrTree<PK>, PK> extends LrTree<PK>{
	
	public void setChildren(List<T> list);
}
