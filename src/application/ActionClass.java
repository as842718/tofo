package application;

import javafx.beans.property.SimpleStringProperty;

public class ActionClass {
	
	public SimpleStringProperty UserAction;
	
	public SimpleStringProperty Locators;

	public SimpleStringProperty value;
	
	public SimpleStringProperty Comment;

	public ActionClass(String userAction, String locators, String value, String comment) {
		super();
		this.UserAction = new SimpleStringProperty(userAction);
		this.Locators = new SimpleStringProperty(locators);;
		this.value = new SimpleStringProperty(value);
		this.Comment = new  SimpleStringProperty(comment);
	}
	


	public ActionClass() {
	
	}



	public String getUserAction() {
		return UserAction.get();
	}



	public void setUserAction(String userAction) {
		UserAction = new SimpleStringProperty(userAction);
	}



	public String getLocators() {
		return Locators.get();
	}



	public void setLocators(String locators) {
		this.Locators = new SimpleStringProperty(locators);
	}



	public String getValue() {
		return value.get();
	}



	public void setValue(String value) {
		this.value = new SimpleStringProperty(value);
	}



	public String getComment() {
		return Comment.get();
	}



	public void setComment(String comment) {
		Comment = new SimpleStringProperty(comment);
	}



	
	
	

}
