package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	 @Inject
	 private BoardService service;
	
	 //게시물 목록
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public void getList(Model model) throws Exception {
	  
		 List list = null;
		 list = service.list();
		 model.addAttribute("list", list);
	 }
	 
	// 게시물 작성
	 @RequestMapping(value = "/write", method = RequestMethod.GET)
	 public void getWirte2() throws Exception {
	    
	 }
	 
	 //게시물작성
	 @RequestMapping(value = "/write", method = RequestMethod.POST)
	 public String postWrite(BoardVO vo) throws Exception {		 
		 service.write(vo);
		 return "redirect:/board/list";		 
	 }
	 
	 //게시물조회
	 //@RequestParam([문자열])을 이용하면, 주소에 있는 특정한 값을 가져올 수 있습니다. 위 스크린샷에서는 주소에서 bno를 찾아 그 값을 int bno에 넣어줍니다.
	 @RequestMapping(value = "/view", method = RequestMethod.GET)
	 public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
		 BoardVO vo = service.view(bno);
		 model.addAttribute("view",vo);
	 }
	 
	 //게시물수정
	 @RequestMapping(value = "/modify", method = RequestMethod.GET)
	 public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		 BoardVO vo = service.view(bno);
		 model.addAttribute("view",vo);
	 }
	 
	// 게시물 수정
	 @RequestMapping(value = "/modify", method = RequestMethod.POST)
	 public String postModify(BoardVO vo) throws Exception {

		service.modify(vo);	    
	  	return "redirect:/board/view?bno=" + vo.getBno();
	 }
	 
	// 게시물 삭제
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public String getDelete(@RequestParam("bno") int bno) throws Exception {
	   
		 service.delete(bno);  
		 return "redirect:/board/list";
	 }
	 
	 // 게시물목룍 + 페이징추가
	 @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	 public void getListPage(@RequestParam("num") int num, Model model) throws Exception {
		 		 
		 // 게시물 총 갯수
		 int count = service.count();
		  
		 // 한 페이지에 출력할 게시물 갯수
		 int postNum = 10;
		  
		 // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
		 int pageNum = (int)Math.ceil((double)count/postNum);
		  
		 // 출력할 게시물
		 int displayPost = (num - 1) * postNum;
		 
		// 한번에 표시할 페이징 번호의 갯수
		 int pageNum_cnt = 10;

		 // 표시되는 페이지 번호 중 마지막 번호
		 int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);

		 // 표시되는 페이지 번호 중 첫번째 번호
		 int startPageNum = endPageNum - (pageNum_cnt - 1);
		 
		// 마지막 번호 재계산
		 int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		  
		 if(endPageNum > endPageNum_tmp) {
		  endPageNum = endPageNum_tmp;
		 }
		 boolean prev = startPageNum == 1 ? false : true;
		 boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		    
		 List list = null; 
		 list = service.listPage(displayPost, postNum);
		 model.addAttribute("list", list);   
		 model.addAttribute("pageNum", pageNum);
		 
		// 시작 및 끝 번호
		 model.addAttribute("startPageNum", startPageNum);
		 model.addAttribute("endPageNum", endPageNum);

		 // 이전 및 다음 
		 model.addAttribute("prev", prev);
		 model.addAttribute("next", next);
		 
		// 현재 페이지
		 model.addAttribute("select", num);
	 }
	 
}
