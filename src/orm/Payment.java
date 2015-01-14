package orm;

import java.sql.Date;
import java.sql.Timestamp;

public class Payment {
	private String payment_id;
	private int payment_price;
	private Timestamp payment_date;
	private String card_num;
	private String cus_id;
	private String route_id;
	private String bus_id;
	
	public void setPID(String s) {
		this.payment_id = s;
	}
	public String getPID() {
		return payment_id;
	}
	public void setPP(int s) {
		this.payment_price = s;
	}
	public int getPP() {
		return payment_price;
	}
	public void setPD(Timestamp d) {
		this.payment_date = d;
	}
	public Timestamp getPD() {
		return payment_date;
	}
	public void setCN(String s) {
		this.card_num = s;
	}
	public String getCN() {
		return card_num;
	}
	public void setCI(String s) {
		this.cus_id = s;
	}
	public String setCI() {
		return cus_id;
	}
	public void setRI(String s) {
		this.route_id = s;
	}
	public String getRI() {
		return route_id;
	}
	public void setBI(String s) {
		this.bus_id = s;
	}
	public String getBI() {
		return bus_id;
	}
}
