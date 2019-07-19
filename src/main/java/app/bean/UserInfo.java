package app.bean;

public class UserInfo {

	public UserInfo(Integer id, String name, String email, int sex) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.sex = sex;
	}

	public UserInfo(String name, String email, int sex) {
		this.name = name;
		this.email = email;
		this.sex = sex;
	}

	public UserInfo() {
	}

	private Integer id;
	private String name;
	private String email;
	private int sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

}