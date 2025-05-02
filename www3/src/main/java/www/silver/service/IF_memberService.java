package www.silver.service;

import www.silver.VO.MemberVO;

public interface IF_memberService {
	
	//addUser는 회원가입 비지니스를 처리하기 위해 정의된 함수 
	//매개변수가 MemberVO, memberVO 인 것은 컨트롤러가 회원의 정보를 넘겨줄떄 이를 받기 위한 것
	//리턴타입인 void인 것은 데이터베이스 작업 결과를 컨투롤러에게 리턴할 필요가 없기 떄문이다.
	public void addUser(MemberVO membervo);
	
	public MemberVO viewUser(String id);
	

}
