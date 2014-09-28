package kr.co.eco.dao;

import kr.co.eco.vo.MemberVO;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO memberDAO;
	private MemberVO memberVO;
	@Test
	public void testAddMember(){
		memberVO = new MemberVO();
		
		memberVO.setMemberEmail("yjm");
		memberVO.setMemberID("YYY");
		memberVO.setMemberPW("aaa");
		int count = memberDAO.addMember(memberVO);
		assertEquals(1, count);
	}
	@Test
	public void testUpdateMember(){
		memberVO = new MemberVO();
		
		memberVO.setMemberID("YYY");
		memberVO.setMemberEmail("mjy");
		memberVO.setMemberPW("bbb");
		
		int count = memberDAO.updateMember(memberVO);
		assertEquals(1, count);
	}
	
	@Test
	public void testDeleteMember(){
		memberVO = new MemberVO();
		
		memberVO.setMemberID("YYY");
		int count = memberDAO.deleteMember(memberVO.getMemberID());
		assertEquals(1, count);
	}
	
	@Test
	public void testGetMember(){
		memberVO = new MemberVO();
		
		memberVO.setMemberID("YYY");
		memberVO = memberDAO.getMember(memberVO.getMemberID());
		assertEquals("yjm", memberVO.getMemberEmail());
	}
	@Test
	public void testGetMemberList(){
		memberVO = new MemberVO();
		assertEquals(1,memberDAO.getMemberList().size());
		
	}

}
