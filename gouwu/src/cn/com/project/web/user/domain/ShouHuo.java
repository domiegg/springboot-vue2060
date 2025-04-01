package cn.com.project.web.user.domain;

public class ShouHuo {
    private Integer id;
    
    private Integer uId;
    
    private Integer moren;

    private String sname;

    private String stel;

    private String youbian;

    private String sheng;

    private String shi;

    private String xian;

    private String address;

    
    public Integer getMoren() {
		return moren;
	}

	public void setMoren(Integer moren) {
		this.moren = moren;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel == null ? null : stel.trim();
    }

    public String getYoubian() {
        return youbian;
    }

    public void setYoubian(String youbian) {
        this.youbian = youbian == null ? null : youbian.trim();
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng == null ? null : sheng.trim();
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi == null ? null : shi.trim();
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian == null ? null : xian.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}