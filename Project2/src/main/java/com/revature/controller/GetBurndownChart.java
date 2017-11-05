package com.revature.controller;

import java.time.LocalDate;
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
import com.revature.beans.Story;
import com.revature.dto.ChartDto;
import com.revature.service.AppService;

@RestController
public class GetBurndownChart {

	@Autowired
	AppService service;

	@RequestMapping(value = "/displayChart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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

		ChartDto burndownChart = new ChartDto();

		return new ResponseEntity<ChartDto>(burndownChart, HttpStatus.OK);
	}
}
