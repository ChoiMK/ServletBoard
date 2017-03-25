package kr.or.ddit.vo;

public class MemberVO {
	private static MemberVO memberVO = new MemberVO();
	
	public static MemberVO getInstance(){
		return memberVO;
	}
	
	private String mem_id;
	private String mem_pass;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	
}

