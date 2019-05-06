package com.sh.lrtree.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sh.lrtree.struct.LrBuildableTree;
import com.sh.lrtree.struct.LrTree;

public class LrTreeUtils {
	
	/**
	 * 构建树，并且更新填充左右值，一般用于树结构变动时使用
	 * @param list
	 * @param parentId
	 * @return
	 */
	public static synchronized <T extends LrBuildableTree<T, PK>, PK> List<T> fullBuild(List<T> list, PK parentId){
		List<T> result = buildListToSortedTree(list, parentId);
		recursiveCalcLr(result, 0);
		recursiveFillLevel(result, 0);
		return result;
	}
	
	/**
	 * 将从数据库查询出来的简单列表，内存中构建为树结构.
	 * @param list
	 * @param int parentId
	 * @return 树结构
	 */
	public static synchronized <T extends LrBuildableTree<T, PK>, PK> List<T> buildListToSortedTree(List<T> list, PK parentId){
		
		List<T> root = new ArrayList<T>();
		
		for(int i = list.size() - 1; i >= 0; i--){
			
			T item = list.get(i);

			//数字类型的等于比较
			if(item.getId() instanceof Number) {
				if(item.getParentId() !=null && item.getParentId().equals(parentId)){
					root.add(item);
					list.remove(i);
				}
			}else if(item.getId() instanceof CharSequence){		//字符串类型的等于 比较

				if(item.getParentId() !=null && item.getParentId().toString().equals(parentId.toString())){
					root.add(item);
					list.remove(i);
				}
			}
		}
		
		Collections.reverse(root);
		
		for(int i=0; i<root.size(); i++){
			if(list.size() > 0){
				T t = root.get(i);
				t.setChildren(buildListToSortedTree(list, t.getId()));
			}
		}

		return root;
	}
	
	/**
	 * 预计算并填充左右值
	 * @param list
	 * @param parentLeft
	 * @return int 最终的右值
	 */
	public static synchronized <PK> int recursiveCalcLr(List<? extends LrTree<PK>> list, int parentLeft){
		
		int cLeft = parentLeft;
		
		if(list == null){
			return cLeft + 1;	//return parent right value;
		}
		
		for(int i=0; i<list.size(); i++){

			LrTree<PK> dept = list.get(i);
			
			if(dept.getChildren() == null){
				cLeft += 1;
				dept.setLeftValue(cLeft);
				cLeft += 1;
				dept.setRightValue(cLeft);
			}else{
				cLeft += 1;
				dept.setLeftValue(cLeft);
				cLeft = recursiveCalcLr(dept.getChildren(), cLeft);
				dept.setRightValue(cLeft);
			}
		}
		
		return cLeft + 1;
	}
	
	/**
	 * 填充当前节点的Level 信息， 因为速度很快，没有复杂操作，所以没有设计合并到 上面两个方法中
	 * @param list
	 * @param parentLeft
	 * @return int 最终的右值
	 */
	public static synchronized <PK>  void recursiveFillLevel(List<? extends LrTree<PK>> list, final int parentLevel){
		if(list == null || list.size() == 0){
			return;
		}
		for(int i=0; i<list.size(); i++){

			LrTree<PK> dept = list.get(i);
			
			dept.setLevel(parentLevel + 1);
			
			if(dept.getChildren() != null){
				
				recursiveFillLevel(dept.getChildren(), parentLevel + 1);
			}
		}
	}
	
	/**
	 * 将树结构扁平化为列表, 不会修改源树结构，只是添加源数据结构中的每一项到新的列表中
	 */
	public static <T extends LrTree<PK>, PK> List<T> flatformTree(final List<T> src) {
		List<T> target = new ArrayList<T>();
		
		flatformTreeInternal(src, target);
		
		return target;
	}
	
	private static <T extends LrTree<PK>, PK> void flatformTreeInternal(final List<T> src, List<T> target) {
		
		for(T t: src) {
			List<T> childs = t.getChildren();
			
			if(childs != null) {
				flatformTreeInternal(childs, target);
			}
			
			target.add(t);
		}
	}
}
