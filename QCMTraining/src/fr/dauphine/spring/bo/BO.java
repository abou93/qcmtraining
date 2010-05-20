package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.sql.Timestamp;

abstract public class BO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3647614335420874969L;

	protected Long id;
	
	protected Timestamp version;

	public BO() {
		
	}
	
	public BO(Long id) {
		this.id = id;
	}

	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getVersion() {
		return version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}
}
