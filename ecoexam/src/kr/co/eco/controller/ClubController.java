package kr.co.eco.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.eco.service.BoardService;
import kr.co.eco.service.ClubService;
import kr.co.eco.vo.BoardVO;
import kr.co.eco.vo.ClubJoinVO;
import kr.co.eco.vo.ClubMemberVO;
import kr.co.eco.vo.ClubVO;
import kr.co.eco.vo.CommentsVO;
import kr.co.eco.vo.MemberVO;
import kr.co.eco.vo.PostNoVO;
import kr.co.eco.vo.PostVO;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClubController {

	@Autowired
	private ClubService clubService;
	@Autowired
	private BoardService boardService;
	

	//study group누르면 들어가는 부분
	@RequestMapping("clubIndex.eco")
	public ModelAndView clubIndex(){
		ModelAndView mv = new ModelAndView("clubIndex");
		return mv;
	}
	
	//클럽 만들기 링크
	@RequestMapping("clubCreateForm.eco")
	public ModelAndView clubCreateForm(){
		ModelAndView mv = new ModelAndView("clubCreateForm");
		List<String> clubNameList = clubService.getClubNameList();
//		String[] clubNameArr = clubNameList.toArray(new String[clubNameList.size()]);
		mv.addObject("clubNameList", clubNameList);
		return mv;
	}
	//클럽 만들기
	@RequestMapping("clubCreate.eco")
	public ModelAndView clubCreate(ClubVO clubVO,HttpSession session){
		ModelAndView mv = new ModelAndView("redirect:/clubPage.eco");
		BoardVO boardVO = new BoardVO();

		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		String clubManagerID = null;
		if(member==null){
			clubManagerID = "user01";
		}
		else{
			clubManagerID = member.getMemberID();
		}
		clubVO.setClubManagerID(clubManagerID);
		int clubNo = clubService.addClub(clubVO);
		boardVO.setBoardName(String.valueOf(clubNo));
		int boardNo = boardService.addBoard(boardVO);
		clubService.updateClubBoardNo(clubNo, boardNo);
		clubService.addClubJoinManager(clubNo,clubManagerID,"clubmanager","true");
		mv.addObject("clubNo", clubNo);
		return mv;
	}
	
	//클럽 페이지
	@RequestMapping("clubPage.eco")
	public ModelAndView clubPage(int clubNo,HttpSession session){
		ModelAndView mv = new ModelAndView("clubPage");
		ClubVO clubVO = clubService.getClub(clubNo);
		List<PostVO> posts = null;
		try{
			posts = boardService.getPostList(clubVO.getClubBoardNo());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		ClubJoinVO clubJoinVO = null;
		try{
			clubJoinVO = clubService.getClubJoin(clubNo,member.getMemberID());
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.addObject("posts", posts);
		mv.addObject("clubVO", clubVO);
		mv.addObject("clubJoinVO",clubJoinVO);
		return mv;
	}
	
	//그룹내 게시글 작성 클릭
	@RequestMapping("clubPostingForm.eco")
	public ModelAndView clubPostingForm(int clubNo){
		ModelAndView mv = new ModelAndView("clubPostingForm");
		ClubVO clubVO = clubService.getClub(clubNo);
		mv.addObject("clubVO", clubVO);
		return mv;
	}
	
	//form에서 입력하고 작성 누름
	@RequestMapping("clubPosting.eco")
	public ModelAndView clubPosting(HttpSession session,PostVO postVO,String boardName){
		ModelAndView mv = new ModelAndView("redirect:/clubPage.eco");
		
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		String memberID = null;
		if(member!=null){
			memberID = member.getMemberID();
		}
		else{
			memberID="user01";
		}
		postVO.setMemberID(memberID);
		//post insert
		System.out.println(postVO);
		boardService.addPost(boardName,postVO);

		mv.addObject("clubNo", boardName);
		return mv;
	}

	
	//club 게시판
	@RequestMapping("clubBoard.eco")
	public ModelAndView clubBoard(int postNo, int clubNo){
		ModelAndView mv = new ModelAndView("clubBoard");
		PostVO postVO = boardService.getPost(postNo);
		boardService.updatePostCount(postNo, (postVO.getPostCount()+1));	
		ClubVO clubVO = clubService.getClub(clubNo);
		List<CommentsVO> comments = boardService.getCommentsList(postNo);
		List<PostNoVO> postNoList = boardService.getAllPostNo(postVO.getBoardNo());
		for(PostNoVO no : postNoList) {
			if(postNo == no.getPostNo()) {
				mv.addObject("postNoList", no);
			}
		}
		mv.addObject("post", postVO);
		mv.addObject("clubVO", clubVO);
		mv.addObject("comments",comments);
		return mv;
	}
	
	@RequestMapping("commentOk.eco")
	public @ResponseBody String commentOk(@RequestBody String data){
		try {
			data = URLDecoder.decode(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int postNo= Integer.parseInt(data.split("&")[0].split("=")[1]);
		String memberID= data.split("&")[1].split("=")[1];
		String commentsContent=data.split("&")[2].split("=")[1];
		
		boardService.addComments(postNo, memberID, commentsContent);		
		
		JSONObject jobj = new JSONObject();
		try{
			jobj.put("memberID",URLEncoder.encode(memberID, "utf-8"));
			jobj.put("commentsContent",URLEncoder.encode(commentsContent, "utf-8"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return jobj.toString();
	}
	//검색 버튼 누름
	@RequestMapping("clubSearch.eco")
	public ModelAndView clubSearch(String searchStr){
		System.out.println("searchStr : "+searchStr);
		ModelAndView mv = new ModelAndView("clubSearchList");
		
		List<ClubVO> list = clubService.getClubListByClubName(searchStr);
		System.out.println("controller : "+list);
		mv.addObject("clubSearchList", list);
		mv.addObject("searchStr", searchStr);
		
		return mv;
	}


	//club 가입
	@RequestMapping("clubJoin.eco")
	public ModelAndView clubJoin(int clubNo,HttpSession session){
		ModelAndView mv = new ModelAndView();
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		if(member==null){
			mv.setViewName("redirect:/loginForm.eco");
		}
		else{
			clubService.addClubJoin(clubNo,member.getMemberID());
			ClubVO clubVO = clubService.getClub(clubNo);
			mv.addObject("clubVO", clubVO);
			mv.addObject("member", member);
			System.out.println(clubVO);
			System.out.println(member);
			mv.setViewName("clubJoin");
		}
		return mv;
	}
	
	//클럽관리페이지
	@RequestMapping("clubManage.eco")
	public ModelAndView clubManage(int clubNo){
		ModelAndView mv = new ModelAndView("clubManage");
		ClubVO clubVO = clubService.getClub(clubNo);
		List<ClubMemberVO> clubJoins = clubService.getClubJoinList(clubNo);		
		mv.addObject("clubVO", clubVO);
		mv.addObject("clubJoins", clubJoins);
		return mv;
	}
	
	//club 게시글 update
	@RequestMapping("clubPostUpdateForm.eco")
	public ModelAndView clubPostUpdateForm(int postNo,int clubNo){
		ModelAndView mv = new ModelAndView("clubPostUpdateForm");
		PostVO postVO = boardService.getPost(postNo);
		mv.addObject("postVO", postVO);
		mv.addObject("clubNo", clubNo);
		return mv;
	}
	// 글 수정
	@RequestMapping("clubPostUpdate.eco")
	public String postUpdate(PostVO postVO, int clubNo) {
		int count = boardService.updatePostVO(postVO);
		if(count > 0) {
			return "redirect:clubBoard.eco?postNo="+postVO.getPostNo()+"&clubNo="+clubNo;
		}
		return "error";
	}
	
	//클럽가입승인
	@RequestMapping("clubJoinAgree.eco")
	public ModelAndView clubBestMore(int clubNo, String memberID,int state){
		ModelAndView mv = new ModelAndView("redirect:clubManage.eco");
		ClubJoinVO clubJoinVO = clubService.getClubJoin(clubNo, memberID);
		if(state==1){
			clubService.deleteClubJoin(clubNo, memberID);
		}
		else if(state==0){
			String clubAgreeOk = "true";
			clubService.updateClubJoinAgreeOk(clubNo, memberID, clubAgreeOk);
		}	
		mv.addObject("clubNo", clubNo);
		return mv;
	}
	
	//best club 우상단에 있는 more 누름
	@RequestMapping("clubBestMore.eco")
	public ModelAndView clubBestMore(){
		ModelAndView mv = new ModelAndView("clubBestMore");
		mv.addObject("object", "object");
		return mv;
	}
	
	//new club 우상단에 있는 more 누름
	@RequestMapping("clubNewMore.eco")
	public ModelAndView clubNewMore(){
		ModelAndView mv = new ModelAndView("clubNewMore");
		mv.addObject("object", "object");
		return mv;
	}
	
	//my스터디그룹 누름
	@RequestMapping("clubMine.eco")
	public ModelAndView clubMine(){
		ModelAndView mv = new ModelAndView("clubMine");
		mv.addObject("object", "object");
		return mv;
	}
	
	//스터디 그룹 보러가기 클릭
	@RequestMapping("club/{clubNo}.eco")
	public ModelAndView groupMine(@PathVariable int clubNo){
		ModelAndView mv = new ModelAndView("club");
		mv.addObject("object", "object");
		return mv;
	}
	
	//클럽정보확인
	@RequestMapping("clubInfoMore.eco")
	public ModelAndView clubInfoMore(){
		ModelAndView mv = new ModelAndView("clubInfoMore");
		mv.addObject("object", "object");
		return mv;
	}
	
	//club test 더보기
	@RequestMapping("clubTestMore.eco")
	public ModelAndView clubTestMore(){
		ModelAndView mv = new ModelAndView("clubTestMore");
		mv.addObject("object", "object");
		return mv;
	}

	//club 탈퇴
	@RequestMapping("clubOut.eco")
	public ModelAndView clubOut(){
		ModelAndView mv = new ModelAndView("clubOut");
		mv.addObject("object", "object");
		return mv;
	}
	
	//club 채팅
	@RequestMapping("clubChat.eco")
	public ModelAndView clubChat(){
		ModelAndView mv = new ModelAndView("clubChat");
		mv.addObject("object", "object");
		return mv;
	}
	
	
	
	
}
