package www.silver.repository;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.VO.MemberVO;

@Repository
public class MemberRepository {
	@Inject
	private  SqlSession sqlsession;
	
	public String checkId(String id) {
		return sqlsession.selectOne("aa.joinId", id);
	}
	
	public void save(MemberVO memberVO) {
		sqlsession.insert("aa.insertMem", memberVO);
	}
	
	public String checkPass(String pass) {
		return sqlsession.selectOne("aa.joinPass",pass);
		
	}
	
	public void attachFname(String filename) {
		sqlsession.insert("aa.kuser_attach",filename);
	}
	
}
