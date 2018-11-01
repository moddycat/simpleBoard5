package VO;

public class Member {
	private String userid;
	private String userpwd;
	private String username;
	private String gender;
	private String hobby;
	private String birth;
	private int age;
	private String phone;
	private String address;
	private String introduce;
	
	public Member() {}

	public Member(String userid, String userpwd, String username, String gender, String hobby, String birth, int age,
			String phone, String address, String introduce) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.gender = gender;
		this.hobby = hobby;
		this.birth = birth;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.introduce = introduce;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpwd() {
		return userpwd;
	}


	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", gender=" + gender
				+ ", hobby=" + hobby + ", birth=" + birth + ", age=" + age + ", phone=" + phone + ", address=" + address
				+ ", introduce=" + introduce + "]";
	}
	
}
