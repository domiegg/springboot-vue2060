package cn.com.project.web.user.domain;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String email;

    private String photo;

    private String zpassword;
    
    private String dId;
    
    private String number;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getZpassword() {
		return zpassword;
	}

	public void setZpassword(String zpassword) {
		this.zpassword = zpassword;
	}
	
   
}