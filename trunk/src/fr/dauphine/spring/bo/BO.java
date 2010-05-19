package fr.dauphine.spring.bo;

import java.sql.Timestamp;

abstract public class BO {

	protected String id;
	
	protected Timestamp version;

	public BO() {
		
	}
	
	public BO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Timestamp getVersion() {
		return version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}
}
