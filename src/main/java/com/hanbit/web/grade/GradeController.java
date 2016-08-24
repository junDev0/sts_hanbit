package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);

	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GradeController!Main...");
		return "grade/content.tiles";
	}
	@RequestMapping("/regist")
	public String regist() {
		return "grade/regist.tiles";
	}
	@RequestMapping("/update")
	public String update() {
		return "grade/update.tiles";
	}
	@RequestMapping("/regist")
	public String delete() {
		return "grade/delete.tiles";
	}
	@RequestMapping("/list")
	public String list() {
		return "grade/list.tiles";
	}
	@RequestMapping("/count")
	public String count() {
		return "grade/count.tiles";
	}
	@RequestMapping("/search")
	public String search() {
		return "grade/search.tiles";
	}

}
