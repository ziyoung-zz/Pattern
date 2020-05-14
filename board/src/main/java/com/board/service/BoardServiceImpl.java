package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	 @Inject
	 private BoardDAO dao;
	
	 //게시물목록
	@Override
	public List<BoardVO> list() throws Exception {

		 return dao.list();
	}

	//게시물작성
	@Override
	public void write(BoardVO vo) throws Exception {
				
		dao.write(vo);
	}

	//게시물조회
	@Override
	public BoardVO view(int bno) throws Exception {
		
		return dao.view(bno);
	}

	//게시물 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
	  
		dao.modify(vo);
	}

	//게시물삭제
	@Override
	public void delete(int bno) throws Exception {
		 
		dao.delete(bno);		
	}

	@Override
	public int count() throws Exception {
		return dao.count();
	}

	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
		 return dao.listPage(displayPost, postNum);
	}

}
