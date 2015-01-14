package orm;

public class Route {
	private String route_id;
	private String station_name;
	private String line_id;
	private int price;
	
	public void setRouteID(String s) {
		this.route_id = s;
	}
	public void setStationName(String s) {
		this.station_name = s;
	}
	public void setLineID(String s) {
		this.line_id = s;
	}
	public String getRouteID() {
		return route_id;
	}
	public String getStationName() {
		return station_name;
	}
	public String getLineID() {
		return line_id;
	}
	public void setPrice(int p) {
		this.price = p;
	}
	public int getPrice() {
		return price;
	}
}

