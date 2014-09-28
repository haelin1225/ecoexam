package kr.co.eco.dao;

import kr.co.eco.vo.GradeVO;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class GradeDAOTest {
	@Autowired
	private GradeDAO gradeDAO;
//	private SqlMapClientTemplate sqlMapClientTemplate;
	
	private GradeVO gradeVO = null;

	@Test
	public void testAddGrade() {
		gradeVO = new GradeVO();
		gradeVO.setclubNo(3);
		gradeVO.setmemberID("admin");
		gradeVO.setTestNo("A01");
		gradeVO.setGrade(90);
		int count = gradeDAO.addGrade(gradeVO);
//		int count = sqlMapClientTemplate.update("insertGrade", gradeVO);
		assertEquals(1, count);
	}
	
	@Test
	public void testGetGrade() {
		gradeVO = new GradeVO();
/*		gradeVO.setclubNo(3);
		gradeVO.setmemberID("admin");
		gradeVO.setTestNo("A01");*/
		
//		gradeVO1 = (GradeVO)sqlMapClientTemplate.queryForObject("getGrade", gradeVO.getmemberID());
		gradeVO = (GradeVO)gradeDAO.getGrade(3, "admin", "A01");
		assertEquals(90, gradeVO.getGrade());
	}
}
