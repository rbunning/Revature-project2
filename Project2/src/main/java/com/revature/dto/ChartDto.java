package com.revature.dto;

import java.io.Serializable;

public class ChartDto implements Serializable {

	private static final long serialVersionUID = -2498694799376500427L;
	private String type = "line";
	private ChartDataDto data;

	public ChartDto() {
		super();
	}

	public ChartDto(ChartDataDto data) {
		super();
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public ChartDataDto getData() {
		return data;
	}

	public void setData(ChartDataDto data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ChartDto [type=" + type + ", data=" + data + "]";
	}

}
