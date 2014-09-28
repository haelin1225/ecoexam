package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.AttachFileVO;
import kr.co.eco.vo.ClubTestVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class AttachFileDAOTest {
	@Autowired
	AttachFileDAO dao;
	
	@Test
	public void testAddAttachFile() {
		AttachFileVO vo = new AttachFileVO();
		vo.setFileName("file");
		vo.setPostNo(4);
		assertNotNull(dao.addAttachFile(vo));
	}
	
	@Test
	public void testDeleteAttachFile() {
		assertNotNull(dao.deleteAttachFile(3));
	}
	
	@Test
	public void testUpdateAttachFile() {
		AttachFileVO vo = new AttachFileVO();
		vo.setFileName("file");
		vo.setFileNo(2);
		assertNotNull(dao.updateAttachFile(vo));
	}
	
	@Test
	public void testGetAttachFileList() {
		List<AttachFileVO> list = dao.getAttachFileList(4);
		for(AttachFileVO ct : list) {
			System.out.println(ct);
		}
	}
	
	@Test
	public void testGetAttachFile() {
		System.out.println(dao.getAttachFile(1));
	}

}
