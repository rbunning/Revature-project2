package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LANE_TYPE")

public class LaneType implements Serializable{
	private static final long serialVersionUID = -6640798122939665294L;
	
	@Id
	@Column(name="LT_ID")
	private int ltId;
	
	@Column(name="LT_NAME")
	private String ltName;
	
	public LaneType() {
		super();
	}

	public LaneType(int ltId, String ltName) {
		super();
		this.ltId = ltId;
		this.ltName = ltName;
	}

	public int getLtId() {
		return ltId;
	}

	public void setLtId(int ltId) {
		this.ltId = ltId;
	}

	public String getLtName() {
		return ltName;
	}

	public void setLtName(String ltName) {
		this.ltName = ltName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "LaneType [ltId=" + ltId + ", ltName=" + ltName + "]";
	}
}