package cn.com.project.web.operation.domain;

public class Gwc {
    private Integer id;

    private Integer sId;
    
    private String sname;
    
    private String color;
    
    private String sprice;
    
    private Integer uId;

    private String number;

    private String tPrice;
    private String photo ;
    
    
    public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSprice() {
		return sprice;
	}

	public void setSprice(String sprice) {
		this.sprice = sprice;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String gettPrice() {
		return tPrice;
	}

	public void settPrice(String tPrice) {
		this.tPrice = tPrice;
	}
   
}