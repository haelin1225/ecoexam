package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.FaqVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class FaqDAOTest {
	@Autowired
	private FaqDAO dao;

	@Test
	public void testAddFaq() {
		FaqVO faq = new FaqVO();
		faq.setFaqTitle("�̸��� ������ ��� �ϳ���?");
		faq.setFaqContent("������������ ������������ â���� ���� �����Ͻø� �˴ϴ�.");
		faq.setCategory("ȸ������");
		faq.setBoardNo(1);

		int count = dao.addFaq(faq);
		assertEquals(1, count);
	}
	
	@Test
	public void testUpdateFaq(){
		FaqVO faq = dao.getFaq(1);
		faq.setFaqTitle("��й�ȣ ������ ��� �ϳ���?");

		int count = dao.updateFaq(faq);
		assertEquals(1, count);
	}
	
	@Test
	public void testDeleteFaq(){
		int count = dao.deleteFaq(1);
		assertEquals(1, count);
	}
	
	@Test
	public void testGetFaqList() {
		List<FaqVO> list = dao.getFaqList(1);
		for(FaqVO faq : list) {
			System.out.println(faq);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGetFaqListByCategory() {
		List<FaqVO> list = dao.getFaqListByCategory(1, "ȸ������");
		for(FaqVO faq : list) {
			System.out.println(faq);
		}
		assertEquals(list.size(), 2);
	}
	
}
