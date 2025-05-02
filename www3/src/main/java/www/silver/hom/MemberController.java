package www.silver.hom;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.silver.VO.MemberVO;
import www.silver.VO.WriteVO;
import www.silver.service.IF_memberService;
import www.silver.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	@Inject
	MemberServiceImpl joinService;
	
	@RequestMapping(value= "/memberjoin", method= RequestMethod.GET)
	public String memberjoin() {
		
		return "/member/memberjoinF";
	}
	
	@RequestMapping(value= "/memberjoindd", method= RequestMethod.POST)
	public String memberjoind(@ModelAttribute MemberVO membervo) {
			System.out.println(membervo.getId() + "/" + membervo.getName());
		return "/member/memberjoinF";
	}
	
	
//	if (data != ''){
//		alert("��� ����");
//		document.getElementById("userid").textContent = data + '��� ���� ���̵�';
//	
//	}else {
//		alert("�ߺ��� ���̵� �Դϴ�.");
//		document.getElementById("userid").value = '';
//		document.getElementById("userid").focus();
//	}
//	
	
	@RequestMapping(value="/duplexid", method=RequestMethod.GET)
	@ResponseBody
	public String duplexid(@RequestParam("id") String id) {
		boolean result = joinService.checkId(id);
		if (result) {
			return "";
		}
		
		return id;
	}
	
	//controller �� ���� ��ü�� �ʿ��ؼ� ���� ���� �ߵ�. �̋� ��ü�� null �̴� �̋����� new�����ؼ� ����ߴµ� ���� container���� ���Թ޾ƾ�
	//�Ǳ� ������ @Inject ����ؼ� ��ü�� �ּҸ� ���Թ޴´�.
	@Inject
	IF_memberService memberservice;
	
	@RequestMapping(value="/memberjoind", method = RequestMethod.POST)
	public String memberjoind2(@ModelAttribute MemberVO membervo) {

		memberservice.addUser(membervo);
		
		return "/member/memberjoinF";
	}
	
	
	
	
	@RequestMapping(value="/writePage", method=RequestMethod.GET)
	public String writePage(HttpServletRequest request) {
		
		int writtingNumber = joinService.joinNum();
		System.out.println(writtingNumber);
		request.setAttribute("number", writtingNumber);
		
		int joinViews = joinService.joinViews();
		request.setAttribute("joinCount", joinViews);
		
		
		return "/write/writePage";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@RequestBody WriteVO writevo) {

	//	System.out.println(writevo.getNum() + " " + writevo.getJoinNum() + " " + writevo.getContent());
		joinService.addwrite(writevo);
		
		return "/member/memberjoinF";
	}
	
	
	
	
	
	
	
	
	
}
