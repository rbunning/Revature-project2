package com.revature.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ChartDataDto implements Serializable {

	private static final long serialVersionUID = -4049887702978810999L;
	private String[] labels;
	private List<ChartDatasetDto> datasets;

	public ChartDataDto() {
		super();
	}

	public ChartDataDto(String[] labels, List<ChartDatasetDto> datasets) {
		super();
		this.labels = labels;
		this.datasets = datasets;
	}

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public List<ChartDatasetDto> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<ChartDatasetDto> datasets) {
		this.datasets = datasets;
	}

	@Override
	public String toString() {
		return "ChartDataDto [labels=" + Arrays.toString(labels) + ", datasets=" + datasets + "]";
	}

}
