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
//		alert("사용 가능");
//		document.getElementById("userid").textContent = data + '사용 가능 아이디';
//	
//	}else {
//		alert("중복된 아이디 입니다.");
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
	
	//controller 는 서비스 객체가 필요해서 변수 선언 했따. 이떄 객체는 null 이다 이떄까지 new생성해서 사용했는데 이제 container에서 주입받아야
	//되기 떄문에 @Inject 사용해서 객체의 주소를 주입받는다.
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
