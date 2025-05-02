package www.silver.hom;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.silver.VO.loginVO;

@Controller
public class MyController {
	
	@Resource(name="cname") // 컨테이너로 부터 주입 받는다.
	String name;            // 값이 null이 아닌 주입받은 객체의 주소 -> DI 개념
	
	
	
	@RequestMapping(value= "/", method= RequestMethod.GET)
	public String home() {
		System.out.println("Name : " + name);
		return "index";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public loginVO login(@RequestBody loginVO loginvo ) {
		loginVO ll = new loginVO();
		ll.setId(loginvo.getId());
		ll.setPass(loginvo.getPass());
		return  ll;
	}
	

	

}
