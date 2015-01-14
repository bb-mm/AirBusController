package orm;

import java.sql.Timestamp;

public class Bus {
	private String bus_id; //BUS_ID
	private String bus_no; //BUS_NO.
	private String line_id;
	private Timestamp bus_date;
	private int total_seat;
	private int available_seat;
	
	public String getBusID() {
		return bus_id;
	}
	public void setBusID(String id) {
		this.bus_id = id;
	}
	
	public String getBusNum() {
		return bus_no;
	}
	public void setBusNum(String no) {
		this.bus_no = no;
	}
	
	public String getLineid() {
		return line_id;
	}
	public void setLineID(String id) {
		this.line_id = id;
	}
	
	public Timestamp getData() {
		return bus_date;
	}
	public void setDate(Timestamp d) {
		this.bus_date = d;
	}
	
	public int getTotalSeat() {
		return total_seat;
	}
	public void setTotalSeat(int s) {
		this.total_seat = s;
	}
	
	public int getAvailableSeat() {
		return available_seat;
	}
	public void setAvailableSeat(int s) {
		this.available_seat = s;
	}
}
