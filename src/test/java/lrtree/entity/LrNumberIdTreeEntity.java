package lrtree.entity;

import com.sh.lrtree.entity.LrBaseNumberIdEntity;

public class LrNumberIdTreeEntity extends LrBaseNumberIdEntity<LrNumberIdTreeEntity>{
	
	private String otherField;
	
	public String getOtherField() {
		return otherField;
	}
	
	public void setOtherField(String otherField) {
		this.otherField = otherField;
	}
}
