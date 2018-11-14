package application;

import javafx.beans.property.SimpleStringProperty;

public class ObjectReop {
	

	public ObjectReop(String objectName, String locator) {
		super();
		this.objectName = new SimpleStringProperty(objectName);
		this.locator = new SimpleStringProperty(locator);
	}
	
	
	
	public SimpleStringProperty objectName;
	
	public SimpleStringProperty locator;

	public String getObjectName() {
		return objectName.get();
	}

	public void setObjectName(String objectName) {
		this.objectName = new SimpleStringProperty(objectName);
	}

	public String getLocator() {
		return locator.get();
	}

	public void setLocator(String locator) {
		this.locator = new SimpleStringProperty(locator);
	}

	
	

}
