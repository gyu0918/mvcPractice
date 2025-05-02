package www.silver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.VO.CommentVO;
import www.silver.VO.PostVO;
import www.silver.repository.GalleryRepository;

@Service
public class GalleryService {
	
	@Inject
	GalleryRepository galleryRepository;
	
	public void insertPost(PostVO postVO) {
		 galleryRepository.insertPost(postVO);
	}
	
	public List<PostVO> loadPost() {
		return galleryRepository.loadPost();
	}
	
	public PostVO findPost(int postNum) {
		
		return galleryRepository.findPost(postNum);
	
	}
	
	public int likeUpdate(int postNum) {
		
		return galleryRepository.likeUpdate(postNum);
	}
	
	public void joinUpdate(int postNum) {
		galleryRepository.joinUpdate(postNum);
	}
	
	public List<CommentVO> joinComment(int postNum){
		return galleryRepository.joinComment(postNum);
	}
	
	public void insertComment(CommentVO commentVO) {
		galleryRepository.insertComment(commentVO);
	}

}
