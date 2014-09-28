package kr.co.eco.dao;

import kr.co.eco.vo.MemberAnswerVO;
import kr.co.eco.vo.MemberVO;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class MemberAnswerDAOTest {

	@Autowired
	private MemberAnswerDAO memberAnswerDAO;
//	private SqlMapClientTemplate sqlMapClientTemplate;
	private MemberAnswerVO memberAnswerVO;
	
	@Test
	public void testAddMemberAnswerTest() {
		memberAnswerVO = new MemberAnswerVO();
		memberAnswerVO.setmemberAnswer("´ä");
		memberAnswerVO.setmemberID("admin");
		memberAnswerVO.setQuestionNo(10);
		memberAnswerVO.setTestNo("A01");
		
		int count = memberAnswerDAO.addMemberAnswer(memberAnswerVO);
//		int count = sqlMapClientTemplate.update("insertMemberAnswer", memberAnswerVO);
		assertEquals(1, count);
	}
	
	@Test
	public void testDeleteMemberAnswerTest() {
		memberAnswerVO = new MemberAnswerVO();
		memberAnswerVO.setmemberID("admin");
		memberAnswerVO.setTestNo("A01");
		
		int count = memberAnswerDAO.deleteMemberAnswer(memberAnswerVO.getTestNo(), memberAnswerVO.getmemberID());
		assertEquals(1, count);
	}
	
	@Test
	public void testGetMemberAnswer() {
		memberAnswerVO = new MemberAnswerVO();
		memberAnswerVO.setmemberID("admin");
		memberAnswerVO.setTestNo("A01");
		
		//assertEquals(1, memberAnswerDAO.getMemberAnswerList(memberAnswerVO.getTestNo(), memberAnswerVO.getmemberID()).size());
	}
	
}
