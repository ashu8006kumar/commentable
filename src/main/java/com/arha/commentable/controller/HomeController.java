package com.arha.commentable.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arha.commentable.bo.FeedBo;
import com.arha.commentable.service.FeedService;

@RestController
@RequestMapping("/api/home")
public class HomeController {
	@Autowired
	@Qualifier("firstfeedService")
	private FeedService feedService;

	@GetMapping("")
	public String welcome() {
		return "Hi , Welcome to Spring boot RestController";
	}

	@GetMapping("/list")
	public List<String> list() {
		List<String> names = new ArrayList<String>();
		names.add("Ashish");
		names.add("Dipesh");
		names.add("Ishwor");
		names.add("Sameep");
		names.add("Tenzing");
		names.add("Ashish");
		names.add("Ishwor");
		names.add("Sameep");

		return names;
	}

	@GetMapping("/map")
	public Map<String, String> map() {
		Map<String, String> nameMap = new HashMap<String, String>();
		nameMap.put("key1", "value1");
		nameMap.put("key", "value");
		return nameMap;
	}

	@GetMapping("/bo")
	public List<FeedBo> bo() {
		return feedService.myFeeds();
	}

	@GetMapping("/{name}")
	public String welcome(@PathVariable String name) {
		return "Hi " + name + ", Welcome to Spring boot RestController";
	}

}
