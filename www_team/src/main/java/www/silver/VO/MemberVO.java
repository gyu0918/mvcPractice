package www.silver.VO;

import lombok.Builder;
import lombok.Getter;




public class MemberVO {
	private String id;
	private String pass;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	
}
