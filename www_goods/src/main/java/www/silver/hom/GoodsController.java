package www.silver.hom;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;    
import www.silver.VO.InsertVO;
import www.silver.VO.ResponseVO;
import www.silver.service.GoodsService;



@Controller
public class GoodsController {
	
	static List<String> joinLists = new ArrayList<String>();	
	
	@Inject
	private GoodsService goodsService;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@PostMapping("/insert")
	public String insertGoods(@ModelAttribute InsertVO insertVO) {		
		goodsService.insertGoods(insertVO);
		return "main";
	}
	
	@ResponseBody
	@GetMapping("/searchname")
	public ResponseVO searchname(@RequestParam("goodsname") String goodsname) {
		System.out.println(goodsname);
		
		return goodsService.joinGoods(goodsname);
	}
	
	@ResponseBody
	@GetMapping("joinList")
	public List<String> joinList(@RequestParam("joinContent") String joinContent){
		joinLists.add(0,joinContent);
		
		return joinLists;
	}
	
}
