package www.silver.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.VO.MemberVO;
import www.silver.VO.WriteVO;


@Repository
public class MemberDAOImpl implements IF_MemberDAO{

	@Inject
	private  SqlSession sqlsession;
	
	@Override
	public void insertMember(MemberVO mvo) {
		sqlsession.insert("www.silver.dao.IF_MemberDAO.insertone", mvo);
		
	}
	public int joinNum() {
		int num = sqlsession.selectOne("www.silver.dao.IF_MemberDAO.joinNum");
		return num;
	}
	
	public int joinViews() {
//		return sqlsession.selectOne("www.silver.dao.IF_MemberDAO.joinViews");
		return 0;
	}
	
	public void insertWrite(WriteVO writevo) {
		sqlsession.insert("www.silver.dao.IF_MemberDAO.insertwrite", writevo);
	}
	
	public String joinId(String id) {
		return sqlsession.selectOne("www.silver.dao.IF_MemberDAO.joinId", id);
	}

}
