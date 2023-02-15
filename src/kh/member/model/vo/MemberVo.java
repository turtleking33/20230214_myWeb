package kh.member.model.vo;

/**
 * 
 * @author hh
 * TEST_MEMBER 테이블을 이용하여
 * 0. 첫화면("/", index.jsp)에서 include형태로 header.jsp 넣음. header에 로그인(login Get) 버튼 만들고 - 로그인 되면 로그아웃(logout Get) 버튼으로 토글, nav에 내정보보기(myinfo get) 버턴 구현
 * 로그인 화면에서 로그인 누르면 login post/ 회원가입 버튼 누르면 enroll get으로
 * 1. 회원가입("/enroll") 구현-- 로그인화면 하단에 회원가입 버튼 --get enroll.jsp, post 회원가입 db다녀와서 첫화면으로 이동
 * 회원가입 화면 - 회원가입 (enroll post)버튼 
 * 2. 로그인("/login") 기능 구현 --Get이면 login.jsp로 포워드  / post 로그인확인db 다녀와서 session("lgnss")에 등록하는데, 이름, email, id를 저장 후 첫 화면 이동
 * 3. 로그아웃("/logout") 기능 구현 -- Get 세션만료 후 첫 화면 이동
 * 4. 내 정보 보기("/myinfo") 구현 -- get myinfo.jsp로 화면에 출력
 * 내정보보기 화면에서 하단에 수정(비번 확인하게 하는 것이 좋은데 그냥 바로 진입으로 구현. /infoupdate get방식), 탈퇴 버튼
 * 5. 내 정보 수정하기("/infoupdate) 구현
 * 내정보보기 수정 화면에서 수정누르면(infoupdate post방식으로)
 *
 */

public class MemberVo {
	//   /**는 자바독 주석. 도큐먼트 형태로 만들어줌
//	ID     NOT NULL VARCHAR2(15) 
//	PASSWD NOT NULL VARCHAR2(15) 
//	NAME   NOT NULL VARCHAR2(20) 
//	EMAIL           VARCHAR2(30)
	private String id;
	private String passwd;
	private String name;
	private String email;
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	
}
