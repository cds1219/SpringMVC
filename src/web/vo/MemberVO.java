package web.vo;

public class MemberVO {
	private String id,pw,name;

	public MemberVO(String id, String pw, String name) {	//set으로
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {	//유효성 검사
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
}
