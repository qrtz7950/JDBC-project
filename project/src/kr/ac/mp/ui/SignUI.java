package kr.ac.mp.ui;

public class SignUI extends BaseUI{

	private String name;
	private String id;
	private String password;
	
	@Override
	public void execute() {
		
		System.out.println("회원가입을 진행합니다");
		id 			= scanString("ID를 입력하세요: ");
		name 		= scanString("이름을 입력하세요: ");
		password 	= scanString("비밀번호를 입력하세요: ");
		
		bank.setId(id);
		bank.setName(name);
		bank.setPassword(password);
		
		bankser.sign(bank);
	}
	
}
