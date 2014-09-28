package kr.co.eco.dao.impl;

import java.util.List;

import kr.co.eco.dao.MemberDAO;
import kr.co.eco.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
@Autowired
private SqlMapClientTemplate sqlMapClientTemplate;


@Override
public int addMember(MemberVO memberVO) {
	return sqlMapClientTemplate.update("insertMember", memberVO);
}

@Override
public int updateMember(MemberVO memberVO) {
	return sqlMapClientTemplate.update("updateMember",memberVO);
}

@Override
public int deleteMember(String memberID) {
	
	return sqlMapClientTemplate.delete("deleteMember",memberID);
}

@Override
public MemberVO getMember(String memberID) {
	return (MemberVO)sqlMapClientTemplate.queryForObject("getMember",memberID);
}

@Override
public List<MemberVO> getMemberList() {
	return sqlMapClientTemplate.queryForList("memberList");
}


}
