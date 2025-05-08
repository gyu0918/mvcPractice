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
		//1.��� ����  ����
		memberRepository.save(memberVO);
		
//		// 2. ÷������
//		String[] fname = memberVO.getFilename();
//		for (int i = 0; i < fname.length; i++) {
//			if (fname[i] != null) {
//				//fanme[i]�� ÷������ ���̺� insert�Ѵ�.
//				System.out.println(fname[i] + "�� ÷������ ���̺� insert �Ѵ�.");
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
