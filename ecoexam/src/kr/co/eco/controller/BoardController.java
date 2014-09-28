package kr.co.eco.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.eco.service.BoardService;
import kr.co.eco.vo.CommentsVO;
import kr.co.eco.vo.MemberVO;
import kr.co.eco.vo.PostNoVO;
import kr.co.eco.vo.PostVO;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("main.eco")
	public String main(HttpServletRequest request, HttpSession session){
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		if(member == null)
			System.out.println("Main : login X");
		else
			System.out.println("Main : login O");
		//System.out.println("main.jsp : "+request.getSession().toString());
		return "main";
	}
	
	// ecoexam �̶�?
	@RequestMapping("ecoexam.eco")
	public String ecoexam() {
		return "ecoexam";
	}
	
	// Ŀ�´�Ƽ ����ȭ��
	@RequestMapping("communityIndex.eco")
	public ModelAndView index() {
		List<PostVO> postList = boardService.getAllPostList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("communityIndex");
		mav.addObject("postList", postList);
		return mav;
	}
	
	// ���� �ʱ�ȭ��
	@RequestMapping("boardList.eco") 
	public ModelAndView boardList(int boardNo, @RequestParam(value = "currentPage", defaultValue = "1")int currentPage) {		
		int PAGENUM = 5, PAGING=5;
		List<PostVO> allList = boardService.getPostList(boardNo);

		int totalCount = allList.size(); // ��ü �Խñ� �� ���ϱ�

		int totalPageCount = totalCount / PAGENUM;
		if(totalCount%PAGENUM > 0) totalPageCount++;

		int startRow = (currentPage-1)*PAGENUM + 1;
		int endRow = currentPage*PAGENUM;

		if(endRow > totalCount) {
			endRow = totalCount;
		}

		List<PostVO> list = new ArrayList<PostVO>();
		int j=0;
				
		for(int i=startRow-1; i<endRow; i++) {
			list.add(j, allList.get(i));
			j++;
		}
		
		int startPage = currentPage - ((currentPage-1)%PAGING);
		int endPage = startPage + PAGING-1;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		mav.addObject("boardNo", boardNo);
		mav.addObject("noticeList", list);
		mav.addObject("totalPageCount", totalPageCount);
		mav.addObject("currentPage", currentPage);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		return mav;
	}
	
	// ���ֹ��� �Խ��� �ʱ�ȭ��
	@RequestMapping("faq.eco")
	public ModelAndView faq() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board_faq");
		return mav;
	}
	
	// �����Խ��� �ʱ�ȭ��
	@RequestMapping("free.eco")
	public ModelAndView free() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board_free");
		return mav;
	}
	
	// QnA �Խ��� �ʱ�ȭ��
	@RequestMapping("qna.eco")
	public ModelAndView qna() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board_qna");
		return mav;
	}
	
	// FAQ �� ���
	@RequestMapping("faqWrite.eco")
	public ModelAndView faqWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardWrite");
		return mav;
	}
	
	// Free �� ���
	@RequestMapping("freeWrite.eco")
	public ModelAndView freeWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardWrite");
		return mav;
	}
	
	// �� ��� ��
	@RequestMapping("postWriteForm.eco")
	public ModelAndView postWriteForm(int boardNo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("postWriteForm");
		System.out.println("eco:"+boardNo);
		mav.addObject("boardNo", boardNo);
		return mav;
	}
	

	// �� ���
	@RequestMapping("postWrite.eco")
	public String postWrite(String boardName, PostVO postVO) {
		int count = boardService.addPost(boardName, postVO);

		if(count > 0) {
			return "postWrite";
		}
		return "error";
	}
	
	// �� �б�
	@RequestMapping("postRead.eco")
	public ModelAndView postRead(int postNo) {
		PostVO post = boardService.getPost(postNo);
		boardService.updatePostCount(postNo, (post.getPostCount()+1));
		//post = boardService.getPost(postNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("postRead");
		
		if(post != null) {
			mav.addObject("post", post);
		}
		
		List<PostNoVO> postNoList = boardService.getAllPostNo(post.getBoardNo());
		for(PostNoVO no : postNoList) {
			if(postNo == no.getPostNo()) {
				mav.addObject("postNoList", no);
			}
		}
		
		List<CommentsVO> comments = boardService.getCommentsList(postNo);
		System.out.println(comments);
		mav.addObject("comments",comments);
		mav.addObject("boardNo", post.getBoardNo());
		return mav;
	}
	
	@RequestMapping("comment.eco")
	public @ResponseBody String comment(@RequestBody String data){
		try {
			data = URLDecoder.decode(data, "UTF-8");
			System.out.println(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int postNo= Integer.parseInt(data.split("&")[0].split("=")[1]);
		String memberID= data.split("&")[1].split("=")[1];
		String commentsContent=data.split("&")[2].split("=")[1];
		System.out.println(postNo + " "+ memberID + " "+ commentsContent);
		
		boardService.addComments(postNo, memberID, commentsContent);
		CommentsVO comment = boardService.getComment(postNo);
		
		JSONObject jobj = new JSONObject();
		try{
			jobj.put("memberID",URLEncoder.encode(memberID, "utf-8"));
			jobj.put("commentsContent",URLEncoder.encode(commentsContent, "utf-8"));
			jobj.put("commentsCreateDate", comment.getCommentsCreateDate());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return jobj.toString();
	}
	
	// �� ���� ��
	@RequestMapping("postUpdateForm.eco")
	public ModelAndView postUpdateForm(int postNo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("postUpdateForm");
		PostVO post = boardService.getPost(postNo);
		if(post != null) {
			mav.addObject("post", post);
		}
		return mav;
	}
	
	// �� ����
	@RequestMapping("postUpdate.eco")
	public String postUpdate(String boardName, PostVO postVO) {
		System.out.println(boardName);
		int count = boardService.updatePost(boardName, postVO);
		if(count > 0) {
			return "postUpdate";
		}
		return "error";
	}
	
	// �� ����
	@RequestMapping("postDelete.eco")
	public String postDelete(int postNo) {
		int count = boardService.deletePost(postNo);
		if(count > 0) {
			return "postDelete";
		}
		return "error";
	}
	
	
}
