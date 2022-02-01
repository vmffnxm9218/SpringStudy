package com.example.spring01.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.PointDto;
import com.example.spring01.model.ProductDto;

@Controller
public class MainController {
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("message","Welcome");
		return "main";
	}
	//구구단
	@RequestMapping("multi_table.do")
	public String gugu() {
		return "test/multi_table";
	}
	@RequestMapping("table_result.do")
	public String gugu_result(@RequestParam(defaultValue="3") int num, Model model) {
		String result="";
		for(int i=1; i<=9; i++) {
			result+=num+" x "+i+" = "+num*i+"<br>";
		}
		model.addAttribute("result", result);
		return "test/table_result";
	}
	//성적계산
	@RequestMapping("point.do")
	public String point() {
		return "test/point";
	}
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDto dto, Model model) {
		dto.setTotal(dto.getKor()+dto.getEng()+dto.getMath());
		String avg=String.format("%.2f", dto.getTotal()/3.0);
		dto.setAverage(Double.parseDouble(avg));
		model.addAttribute("dto",dto);
		return "test/point_result";
	}
	//redirect(처리완료후 다른 url로 이동)
	@RequestMapping("move.do")
	public String move() throws Exception{
		String name=URLEncoder.encode("이태욱","utf-8");
		return "redirect:/result.do?name="+name+"&age=20";
	}
	
	@RequestMapping("result.do")
	public String result(Model model, @RequestParam(defaultValue="noname") String name, @RequestParam(defaultValue="10") int age) throws Exception{
		name=URLDecoder.decode(name, "utf-8");
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "test/result";
	}
	//ModelAndView
	@RequestMapping("mav.do")
	public ModelAndView mav() {
		Map<String, Object> map=new HashMap<>();
		map.put("dto", new ProductDto("pen",1000));
		return new ModelAndView("test/mav_result", "map", map);
	}
	//
	@RequestMapping("ajax.do")
	public String ajax() {
		return "test/ajax"; //ajax.jsp로 포워드(스트링 리턴이 아님)
	}
	//@ResponseBody 데이터 자체를 리턴-json형식으로 리턴됨, 이걸 javascript 형식으로 변환해주는 변환기가 필요해서 라이브러리 추가
	@RequestMapping("background.do")
	public @ResponseBody ProductDto background() {
		ProductDto dto=new ProductDto("TV",500000);
		return dto; //데이터 자체를 리턴(@ResponseBody 붙여야함. 아니면 페이지를 찾음)
	}
	//
	@RequestMapping("login.do")
	public String login() {
		return "test/login";
	}
	@RequestMapping("login_result.do")
	public String login_result(@RequestParam String id, String pw, Model model) {
		String result="";
		if(id.equals("double4nine")&&pw.equals("449")){
			result="환영합니다";
		}else {
			result="아이디 또는 비밀번호가 틀렸습니다.";
		}
		model.addAttribute("result", result);
		return "test/login_result";
	}
}
