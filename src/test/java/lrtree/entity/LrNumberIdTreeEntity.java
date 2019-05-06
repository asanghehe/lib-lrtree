package lrtree.entity;

import com.sh.lrtree.entity.LrBaseNumberIdEntity;

/**
 * 继承 库提供的 数字类型ID 的树结构实体
 * @author asang
 *
 */
public class LrNumberIdTreeEntity extends LrBaseNumberIdEntity<LrNumberIdTreeEntity>{
	
	private String otherField;
	
	public String getOtherField() {
		return otherField;
	}
	
	public void setOtherField(String otherField) {
		this.otherField = otherField;
	}
}
