package lrtree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sh.lrtree.util.LrTreeUtils;

import lrtree.entity.CustLrTreeEntity;
import lrtree.entity.LrNumberIdTreeEntity;
import lrtree.entity.LrStringIdTreeEntity;

public class TreeUtilTest {
	
	/**
	 * 将树结构扁平化重构成元素列表，方便用于将构建的树信息回填到数据库/文件等
	 */
	//@Test
	public void flatformTest() {

		List<CustLrTreeEntity> list = new ArrayList<CustLrTreeEntity>();
		
		for(long i =1; i<10; i++) {
			CustLrTreeEntity de = new CustLrTreeEntity();
			de.setId(i);
			de.setOtherField("自定义实体类实现树接口"+i);
			de.setParentId(i-1);
			list.add(de);
		}
		
		List<CustLrTreeEntity> result = LrTreeUtils.buildListToSortedTree(list, 0L);

		String r = JSON.toJSONString(result, true);
		System.out.println(r);
		
		result = LrTreeUtils.flatformTree(result);
		
		r = JSON.toJSONString(result, true);
		System.out.println(r);
	}
	
	/**
	 * 不使用库提供的基类， 自定义类 实现树接口的 测试
	 */
	//@Test
	public void custInterfaceEntityTest() {

		List<CustLrTreeEntity> list = new ArrayList<CustLrTreeEntity>();
		
		for(long i =1; i<10; i++) {
			CustLrTreeEntity de = new CustLrTreeEntity();
			de.setId(i);
			de.setOtherField("自定义实体类实现树接口"+i);
			de.setParentId(i-1);
			list.add(de);
		}
		
		List<CustLrTreeEntity> result = LrTreeUtils.buildListToSortedTree(list, 0L);
		
		String r = JSON.toJSONString(result, true);
		
		System.out.println(r);
	}
	
	/**
	 * 完整的构建树，以及填充左右值，填充元素当前层级 合并方法测试
	 */
	//@Test
	public void fullBuildTest() {

		List<LrNumberIdTreeEntity> list = new ArrayList<LrNumberIdTreeEntity>();
		
		for(long i =1; i<10; i++) {
			LrNumberIdTreeEntity de = new LrNumberIdTreeEntity();
			de.setId(i);
			de.setOtherField("继承数字ID树结构"+i);
			de.setParentId(i-1);
			list.add(de);
		}
		
		List<LrNumberIdTreeEntity> result = LrTreeUtils.fullBuild(list, 0L);
		
		String r = JSON.toJSONString(result, true);
		System.out.println(r);
	}
	
	/**
	 * 基于提供的基类   数字类型的ID 树 测试
	 */
	@Test
	public void numberIdTest() {
		List<LrNumberIdTreeEntity> list = new ArrayList<LrNumberIdTreeEntity>();
		
		for(long i =1; i<5; i++) {
			LrNumberIdTreeEntity de = new LrNumberIdTreeEntity();
			de.setId(i);
			de.setOtherField("继承数字ID树结构"+i);
			de.setParentId(i-1);
			list.add(de);
		}
		List<LrNumberIdTreeEntity> result = null;
		
		//单纯的构建树，一般用于读取
		result = LrTreeUtils.buildListToSortedTree(list, 0L);
		String r = JSON.toJSONString(result, true);
		System.out.println(r);

		//构建树，处理填充左右值，当前level, 用于数据库左右值更新的情况
		result = LrTreeUtils.fullBuild(list, 0L);
		r = JSON.toJSONString(result, true);
		System.out.println(r);
	}
	
	/**
	 * 基于提供的基类  字符串类型ID 树 测试
	 */
	//@Test
	public void stringIdTest() {
		
		List<LrStringIdTreeEntity> list = new ArrayList<LrStringIdTreeEntity>();
		
		for(long i =1; i<10; i++) {
			LrStringIdTreeEntity de = new LrStringIdTreeEntity();
			de.setId("stringId"+i);
			de.setOtherField("继承字符串ID树结构"+i);
			de.setParentId("stringId"+(i-1));
			list.add(de);
		}
		
		List<LrStringIdTreeEntity> result = LrTreeUtils.buildListToSortedTree(list, "stringId0");
		
		String r = JSON.toJSONString(result, true);
		
		System.out.println(r);
	}
}
