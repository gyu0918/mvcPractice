package www.silver.hom;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;    
import www.silver.VO.InsertVO;



@Controller
public class GoodsController {
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@PostMapping("/insert")
	public String insertGoods(@RequestBody InsertVO insertVO) {
		
		System.out.println("sdfsdfsdf");
		return "main";
	}
	
}
