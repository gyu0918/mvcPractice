package www.silver.dao;

import www.silver.VO.MemberVO;

public interface IF_MemberDAO {
	
	//리턴을 서비스단에 하고 , sqlsessiontemplate를 호출한다.
	// 주목적은 쿼리문을 실행하기 위한 것  비지니스 처리량은 구분해야 한다.
	public void insertMember(MemberVO mvo);

}
