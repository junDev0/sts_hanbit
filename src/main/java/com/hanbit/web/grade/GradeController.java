package com.hanbit.web.grade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grade")
public class GradeController {
	@RequestMapping("/main")
	public String goMain(){
		return "grade/content.tiles";
	}
}
