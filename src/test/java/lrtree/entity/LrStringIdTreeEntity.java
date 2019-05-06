package lrtree.entity;

import com.sh.lrtree.entity.LrBaseStringIdEntity;

/**
 * 继承库提供的 字符串类型ID 树结构的实体
 * @author asang
 *
 */
public class LrStringIdTreeEntity extends LrBaseStringIdEntity<LrStringIdTreeEntity>{
	
	private String otherField;
	
	public String getOtherField() {
		return otherField;
	}
	
	public void setOtherField(String otherField) {
		this.otherField = otherField;
	}
}
