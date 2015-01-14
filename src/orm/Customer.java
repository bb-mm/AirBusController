package orm;

public class Customer {
	private String cus_id;
	private String cus_fname;
	private String cus_lname;
	private String cus_phone;
	private String cus_passport;
	
	public void setID(String s) {
		this.cus_id = s;
	}
	public void setFname(String s) {
		this.cus_fname = s;
	}
	public void setLname(String s) {
		this.cus_lname = s;
	}
	public void setPhone(String s) {
		this.cus_phone = s;
	}
	public void setPassport(String s) {
		this.cus_passport = s;
	}
	public String getID() {
		return cus_id;
	}
	public String getFname() {
		return cus_fname;
	}
	public String getLname() {
		return cus_lname;
	}
	public String getPhone() {
		return cus_phone;
	}
	public String getPassport() {
		return cus_passport;
	}
}
