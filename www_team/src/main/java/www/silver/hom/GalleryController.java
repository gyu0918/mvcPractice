package www.silver.hom;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;    
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import www.silver.VO.CommentVO;
import www.silver.VO.MemberVO;
import www.silver.VO.PostVO;
import www.silver.service.GalleryService;
import www.silver.service.MemberService;

@Controller
public class GalleryController {
	
	@Inject
	private GalleryService galleryService;
	
	@GetMapping("/writePost")
	public String writePost() {
		return "/writePage";
	}
	
	@ResponseBody
	@PostMapping("/savePost")
	public String savePost(@RequestBody PostVO postVO) {
		
		
		galleryService.insertPost(postVO);
		
		return "success";
	}
	
	@ResponseBody
	@GetMapping("/loadPost")
	public List<PostVO> loadPost() {
		
		List<PostVO> postVO = galleryService.loadPost();
		
		return postVO;
	}
	
	@GetMapping("/goPost")
	public String goPost(@RequestParam("postNum") int postNum, HttpServletRequest request ) {
		
		PostVO postVO = galleryService.findPost(postNum);
		
		request.setAttribute("id", postVO.getId());
		request.setAttribute("postNum", postVO.getPostNum());
		request.setAttribute("postName", postVO.getPostName());
		request.setAttribute("postContent", postVO.getPostContent());
		request.setAttribute("postDate", postVO.getPostDate());
		request.setAttribute("postLike", postVO.getPostLike());
		
		
		return "/detailPost"; 
	}
	
	@ResponseBody
	@GetMapping("/upLike")
	public int upLike(@RequestParam("postNum") int postNum) {
		return galleryService.likeUpdate(postNum);
	}
	
	@GetMapping("/upJoinCount")
	public void upJoinCount(@RequestParam("postNum") int postNum) {
		galleryService.joinUpdate(postNum);
	}
	
	@ResponseBody
	@GetMapping("/joinComment")
	public List<CommentVO> joinComment(@RequestParam("postNum") int postNum){
		List<CommentVO> temp =  galleryService.joinComment(postNum);
//		for (CommentVO comment : temp) {
//		    System.out.println("작성자: " + comment.getId());
//		    System.out.println("내용: " + comment.getContent());
//		    System.out.println("작성일: " + comment.getCommentDate());
//		    System.out.println("------------------------");
//		}
		return temp;
	}
	
	@ResponseBody
	@PostMapping("saveComment")
	public String saveComment(@RequestBody CommentVO commentVO) {
		
		galleryService.insertComment(commentVO);
		
		
		System.out.println("sdfasfasdfdsafsafasfsdfasdfds");
		System.out.println(commentVO.getId());
		System.out.println(commentVO.getPostNum());
		System.out.println(commentVO.getContent());
		System.out.println(commentVO.getCommentDate());
		System.out.println("sdfasfasdfdsafsafasfsdfasdfds");
		
		return "ok";
	}
	
	
	
}
