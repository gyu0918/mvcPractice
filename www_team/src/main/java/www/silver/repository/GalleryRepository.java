package www.silver.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.VO.CommentVO;
import www.silver.VO.PostVO;
import www.silver.VO.UpdateVO;

@Repository
public class GalleryRepository {

	@Inject
	private  SqlSession sqlsession;
	
	
	public void insertPost(PostVO postVO) {
		sqlsession.insert("aa.insertPost", postVO);
	}
	
	public List<PostVO> loadPost() {
		return sqlsession.selectList("aa.loadPost");
	}
	
	public PostVO findPost(int postNum) {
		return sqlsession.selectOne("aa.findPost", postNum);
	}
	
	public int likeUpdate(int postNum) {
		
		//이런처리는 service 쪽에서 할수 있도록 하기 
		int likeNum =  sqlsession.selectOne("aa.findLikeNum",postNum);
		likeNum++;
		UpdateVO tt = new UpdateVO();
		tt.setLiekNum(likeNum);
		tt.setPostNum(postNum);
		sqlsession.update("aa.updateLikeNum", tt);
		return likeNum;
	}
	
	public void joinUpdate(int postNum) {
		int  joinNum = sqlsession.selectOne("aa.findJoinCount",postNum);
		joinNum++;
		UpdateVO tt = new UpdateVO();
		tt.setJoinNum(joinNum);
		tt.setPostNum(postNum);
		sqlsession.update("aa.updatejoinNum",tt);
	}
	
	public List<CommentVO> joinComment(int postNum){
		
		return sqlsession.selectList("aa.joinComment",postNum);
	}
	
	public void insertComment(CommentVO commentVO) {
		sqlsession.insert("aa.insertComment", commentVO);
	}
	
}
