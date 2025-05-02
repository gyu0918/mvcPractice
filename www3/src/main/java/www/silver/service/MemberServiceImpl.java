package www.silver.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.VO.MemberVO;
import www.silver.VO.WriteVO;
import www.silver.dao.IF_MemberDAO;
import www.silver.dao.MemberDAOImpl;

@Service
public class MemberServiceImpl implements IF_memberService{

	@Inject
	IF_MemberDAO memberDAO;
	
	@Inject
	MemberDAOImpl joinDAO;
	
	@Override
	public void addUser(MemberVO membervo) {
		// TODO Auto-generated method stub
		memberDAO.insertMember(membervo);
	}

	@Override
	public MemberVO viewUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int joinNum() {
	
		int num = joinDAO.joinNum();
		return num;
	}
	
	public int joinViews() {
		int num = joinDAO.joinViews();
		
		return num;
	}
	
	public void addwrite(WriteVO writevo) {
		joinDAO.insertWrite(writevo);
	}
	
	public boolean checkId(String id) {
		String result = joinDAO.joinId(id);
		if (id.equals(result)) {
			return true;
		}
		return false;
	}
	

}
