package com.revature.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Board;
import com.revature.beans.Chart;
import com.revature.beans.Story;
import com.revature.dto.ChartDataDto;
import com.revature.dto.ChartDatasetDto;
import com.revature.dto.ChartDto;
import com.revature.service.AppService;

@RestController
public class GetBurndownChart {

	@Autowired
	AppService service;

	@RequestMapping(value = "/getChart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChartDto> getChartData(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Board board = (Board) session.getAttribute("board");
		Set<Story> stories = board.getStory();
		Map<LocalDate, Integer> storyData = new TreeMap<LocalDate, Integer>();
		int totalPoints = 0;

		for (Story story : stories) {
			totalPoints += story.getStoryPoints();
			if (story.getLaneType().getLtId() == 6) {
				LocalDate doneDate = story.getLastMoveDate().toLocalDate();
				storyData.put(doneDate, story.getStoryPoints());
			}
		}
		List<String> dataLabels = new ArrayList<>();
		List<Integer> dataValues = new ArrayList<>();
		Chart chart = board.getChart();
		LocalDate startDate = chart.getStartDate().toLocalDate();
		dataLabels.add(startDate.toString());
		dataValues.add(totalPoints);
		LocalDate prevDate = startDate;

		for (Map.Entry<LocalDate, Integer> entry : storyData.entrySet()) {
			LocalDate currentDate = entry.getKey();
			Integer points = entry.getValue();
			if (prevDate.equals(startDate) || prevDate.equals(currentDate)) {
				prevDate = currentDate;
				totalPoints -= points;
			} else {
				dataLabels.add(prevDate.toString());
				dataValues.add(totalPoints);
				prevDate = currentDate;
				totalPoints -= points;
			}
		}
		dataLabels.add(prevDate.toString());
		dataValues.add(totalPoints);

		String[] dataLabelsArray = dataLabels.toArray(new String[dataLabels.size()]);
		int[] dataValuesArray = new int[dataValues.size()];
		for (int i = 0; i < dataValuesArray.length; i++) {
			dataValuesArray[i] = dataValues.get(i).intValue();
		}
		ChartDatasetDto cdsd = new ChartDatasetDto(dataValuesArray);
		List<ChartDatasetDto> cdsdList = new ArrayList<>();
		cdsdList.add(cdsd);
		ChartDataDto cdd = new ChartDataDto(dataLabelsArray, cdsdList);
		ChartDto burndownChart = new ChartDto(cdd);

		return new ResponseEntity<ChartDto>(burndownChart, HttpStatus.OK);
	}
}
