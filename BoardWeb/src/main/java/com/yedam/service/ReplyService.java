package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchVO;
import com.yedam.vo.CartVO;
import com.yedam.vo.CenterVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(SearchVO search); // 목록.
	boolean removeReply(int replyNo); // 삭제.
	boolean addReply(ReplyVO rvo); // 등록.
	int getReplyCnt(int boardNo); // 댓글건수.
	
	// cart...목록, 수정, 삭제
	List<CartVO> cartList();
	boolean modifyCart(CartVO cvo);
	boolean removeCart(int no);
	
	int addCenter(CenterVO[] array);
	List<Map<String, String>> categoryList();
	
}
