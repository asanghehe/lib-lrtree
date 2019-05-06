package lrtree.entity;

import com.sh.lrtree.entity.LrBaseStringIdEntity;

public class LrStringIdTreeEntity extends LrBaseStringIdEntity<LrStringIdTreeEntity>{
	
	private String otherField;
	
	public String getOtherField() {
		return otherField;
	}
	
	public void setOtherField(String otherField) {
		this.otherField = otherField;
	}
}
