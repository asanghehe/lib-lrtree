package lrtree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sh.lrtree.util.LrTreeUtils;

import lrtree.entity.LrNumberIdTreeEntity;
import lrtree.entity.LrStringIdTreeEntity;

public class TreeUtilTest {
	
	/**
	 * 数字类型的ID 树 测试
	 */
	@Test
	public void numberIdTest() {
		
		List<LrNumberIdTreeEntity> list = new ArrayList<LrNumberIdTreeEntity>();
		
		for(long i =1; i<20; i++) {
			LrNumberIdTreeEntity de = new LrNumberIdTreeEntity();
			de.setId(i);
			de.setOtherField("abc"+i);
			de.setParentId(i-1);
			list.add(de);
		}
		
		List<LrNumberIdTreeEntity> result = LrTreeUtils.buildListToSortedTree(list, 0L);
		
		String r = JSON.toJSONString(result);
		
		System.out.println(r);
	}
	
	/**
	 * 字符串类型的ID测试
	 */
	@Test
	public void stringIdTest() {
		
		List<LrStringIdTreeEntity> list = new ArrayList<LrStringIdTreeEntity>();
		
		for(long i =1; i<20; i++) {
			LrStringIdTreeEntity de = new LrStringIdTreeEntity();
			de.setId("stringId"+i);
			de.setOtherField("name"+i);
			de.setParentId("stringId"+(i-1));
			list.add(de);
		}
		
		List<LrStringIdTreeEntity> result = LrTreeUtils.buildListToSortedTree(list, "stringId0");
		
		String r = JSON.toJSONString(result);
		
		System.out.println(r);
	}
}
