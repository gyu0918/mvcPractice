package www.silver.hom;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import www.silver.VO.MemberVO;
import www.silver.hom.util.FileDataUtil;
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
	
	@Inject
	private  FileDataUtil filedatautil;
	
	
	//바이너리 파일 부분
	@PostMapping("/save")
	public String save( @ModelAttribute MemberVO memberVO, @RequestParam("file") MultipartFile[] file) throws IOException {
		
		String[] filename = filedatautil.fileUpload(file);
		memberVO.setFilename(filename);
		memberService.save(memberVO);
		
		
		return "redirect:/";
		

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
