package com.revature.dto;

import java.io.Serializable;
import java.util.Arrays;

public class ChartDatasetDto implements Serializable {

	private static final long serialVersionUID = 7343446286048918735L;
	private String label = "Story Points";
	private int[] data;
	private String borderColor = "#3e95cd";
	private boolean fill = false;

	public ChartDatasetDto() {
		super();
	}

	public ChartDatasetDto(int[] data) {
		super();
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

	public String getBorderColor() {
		return borderColor;
	}

	public boolean isFill() {
		return fill;
	}

	@Override
	public String toString() {
		return "ChartDatasetDto [label=" + label + ", data=" + Arrays.toString(data) + "]";
	}

}
