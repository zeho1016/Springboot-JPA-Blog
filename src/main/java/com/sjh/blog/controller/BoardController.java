package com.sjh.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sjh.blog.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// /WEB-INF/views/index.jsp
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size=3, sort="id", direction=Sort.Direction.DESC)Pageable pageable) { //컨트롤러에서 세션을 어떻게 찾는지?
		model.addAttribute("boards", boardService.글목록(pageable)); 
		return "index"; //viewResolver가 작동, 해당 페이지로 model의 정보를 넘김
	}
	@GetMapping("/board/{id}/updateForm" )
	public String updateFrom(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "/board/updateForm";
	}
	
	// user권한이 필요
	@GetMapping("board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	@GetMapping("board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "board/detail";
	}
	
	
}
