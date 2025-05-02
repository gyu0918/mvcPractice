package www.silver.hom;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;    
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import www.silver.VO.MemberVO;
import www.silver.service.MemberService;


@Controller
@Slf4j
public class PokemonController {
	
	@Inject
	private MemberService memberService;
	
	@GetMapping("/")
	public String login() {
		return "/login/login";
	}
	
	@GetMapping("/saveId")
	public String saveId() {
		
		return "/login/saveId";
	}
	
	@GetMapping("/gallery")
	public String gallery() {
		
		return "/gallery";
	}
	
	@GetMapping("/check")
	@ResponseBody
	public String checkId(@RequestParam("id") String id ) {
		

		String result = memberService.checkId(id);
		
		if ("true".equals(result)) {
			return "true";
		}
		
		return "";
	}
	
	@PostMapping("/save")
	public void save(@RequestBody MemberVO memberVO) {
		memberService.save(memberVO);
	}
	
	@PostMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(@RequestBody MemberVO memberVO) {
		boolean result = memberService.loginCheck(memberVO);
		if (result) {
			return "true";
		}
		return "";
	}
	
	
	
	
	
	
}
