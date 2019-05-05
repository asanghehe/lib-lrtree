package com.sh.lrtree.struct;

/**
 * 可提供 给TreeUtils 进行排序树构建的类实现接口
 * @author asang
 *
 */
public interface LrSortedBuildableTree<T extends LrTree<PK>, PK> extends LrBuildableTree<T, PK>{

	public Integer getSort();
}
