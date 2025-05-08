package www.silver.VO;

public class PostVO {
	private String id;
	private int postNum;    //primary key!!
	private String postName;
	private String postContent;
	private int postCount;
	private int postLike;
	private String postDate;
	private String[] filename;
	
	
	
	public String[] getFilename() {
		return filename;
	}
	public void setFilename(String[] filename) {
		this.filename = filename;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	public int getPostLike() {
		return postLike;
	}
	public void setPostLike(int postLike) {
		this.postLike = postLike;
	}
	
	public String getPostDate() {
		return postDate;
	}
	
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
	

}
