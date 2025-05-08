package www.silver.hom;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import www.silver.VO.CommentVO;
import www.silver.VO.MemberVO;
import www.silver.VO.PostVO;
import www.silver.hom.util.FileDataUtil;
import www.silver.service.GalleryService;
import www.silver.service.MemberService;

@Controller
public class GalleryController {
	
	@Inject
	private FileDataUtil filedatautil;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Inject
	private GalleryService galleryService;
	
	@GetMapping("/writePost")
	public String writePost() {
		return "/writePage";
	}
	
	
	@ResponseBody
	@GetMapping("/joinPhoto")
	public List<String> joinPhoto(@RequestParam("postNum") int postNum){
		
		
		List<String> photo = galleryService.joinPhoto(postNum); 
		
		for (String photos : photo) {
			System.out.println(photos);
		}
		
		
		return photo;
	}
	
	@ResponseBody
	@PostMapping("/savePost")
	public String savePost(@ModelAttribute PostVO postVO, @RequestParam("file") MultipartFile[] file ) throws IOException {
		String[] filename = filedatautil.fileUpload(file);
//		System.out.println(postVO.getPostContent());
		postVO.setFilename(filename);
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
		
		
		//첨부파일 가져온다.
		
		
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
