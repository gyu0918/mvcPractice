package www.silver.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import www.silver.VO.MemberVO;
import www.silver.repository.MemberRepository;

@Service
public class MemberService {
	
	@Inject
	private MemberRepository memberRepository;
	
	
	public String checkId(String id) {
		String check = memberRepository.checkId(id);
	
		if (id.equals(check)) {
			return "true";
		}
		return "false";
	}
	
	public void save(MemberVO memberVO) {
		memberRepository.save(memberVO);
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
