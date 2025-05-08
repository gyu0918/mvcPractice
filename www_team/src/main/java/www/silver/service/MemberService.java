package www.silver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import www.silver.VO.MemberVO;
import www.silver.repository.MemberRepository;

@Service
public class MemberService {
	
	@Inject
	private MemberRepository memberRepository;
	
	
	
//	public List<String> getAttach(String id){
//		return memberRepository.getAttach(id);
//	}
//	
	
	
	
	public String checkId(String id) {
		String check = memberRepository.checkId(id);
	
		if (id.equals(check)) {
			return "true";
		}
		return "false";
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void save(MemberVO memberVO) {
		//1.사람 저장  저장
		memberRepository.save(memberVO);
		
//		// 2. 첨부파일
//		String[] fname = memberVO.getFilename();
//		for (int i = 0; i < fname.length; i++) {
//			if (fname[i] != null) {
//				//fanme[i]를 첨부파일 테이블에 insert한다.
//				System.out.println(fname[i] + "를 첨부파일 테이블에 insert 한다.");
//				
//			}
//		}
	}
	
	public boolean loginCheck(MemberVO memberVO) {
		
		String checkId = memberRepository.checkId(memberVO.getId());
		String checkPass = memberRepository.checkPass(memberVO.getPass());
		
		if (memberVO.getId().equals(checkId)) {
			if (memberVO.getPass().equals(checkPass)) {
				return true;
			}
		}
		
		return false;
	}

}
