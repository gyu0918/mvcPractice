package www.silver.hom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class tempController {

	@RequestMapping(value="/api" , method = RequestMethod.GET)
	public String main() {
	
	    return "temp";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/api/register" , method = RequestMethod.POST)
	public String register(@RequestBody UserRequest userRequest) {
	    System.out.println(userRequest.getName());
	    System.out.println(userRequest.getEmail());
	    System.out.println(userRequest.getPassword());
	    return "회원가입 완료!";
	}
}
