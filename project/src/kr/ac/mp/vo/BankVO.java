package kr.ac.mp.vo;

public class BankVO {

	private static String id;
	private static String name;
	private static String password;
	
	public BankVO() {
		
	}

	public BankVO(String id, String name,String password) {
		this.setId(id);
		this.setName(name);
		this.setPassword(password);
	}

	public BankVO(String id, String password) {
		//로그인용 id 비밀번호 담은 객체생성자
		this.setId(id);
		this.setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
