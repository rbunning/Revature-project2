package com.revature.dto;

import java.io.Serializable;
import java.util.Arrays;

public class ChartDatasetDto implements Serializable {

	private static final long serialVersionUID = 7343446286048918735L;
	private String label = "Points";
	private int[] data;

	public ChartDatasetDto() {
		super();
	}

	public ChartDatasetDto(String label, int[] data) {
		super();
		this.label = label;
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ChartDatasetDto [label=" + label + ", data=" + Arrays.toString(data) + "]";
	}

}
