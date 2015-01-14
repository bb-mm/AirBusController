package orm;

import java.sql.Date;
import java.sql.Time;

public class Line {
	private String line_id;
	private String line_name;
	private String line_type;
	private Time start_time;
	private Time end_time;
	
	public void setLineID(String l) {
		this.line_id = l;
	}
	public void setLineName(String l) {
		this.line_name = l;
	}
	public void setLineType(String l) {
		this.line_type = l;
	}
	public String getLineID() {
		return line_id;
	}
	public String getLineName() {
		return line_name;
	}
	public String getLineType() {
		return line_type;
	}
	public void setStart(Time d) {
		this.start_time = d;
	}
	public void setEnd(Time d) {
		this.end_time = d;
	}
	public Time getStart() {
		return start_time;
	}
	public Time getEnd() {
		return end_time;
	}
	
}
