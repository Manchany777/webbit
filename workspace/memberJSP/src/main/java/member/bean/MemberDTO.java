package member.bean;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	// DTO는 쓰던 안쓰던 테이블 컬럼과 똑같이 맞춰주는 게 좋다. 다른 사람이 쓸 수도 있기때문에
	private String name;
	private String id;
	private String pwd;
	private String gender;
	private String email1;
	private String email2;
	private String tel1;
	private String tel2;
	private String tel3;
	private String zipcode;
	private String addr1;
	private String addr2;
	private Date logtime;
}