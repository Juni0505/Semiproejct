package kh.semiproject.main.model.vo;

public class MainVo {
	private String bshop_Name;
	private double lat;
	private double lng;
	
	
	public MainVo() {
		
	}


	public MainVo(String bshop_Name, double lat, double lng) {
		super();
		this.bshop_Name = bshop_Name;
		this.lat = lat;
		this.lng = lng;
	}


	@Override
	public String toString() {
		return "MainVo [bshop_Name=" + bshop_Name + ", lat=" + lat + ", lng=" + lng + "]";
	}


	public String getBshop_Name() {
		return bshop_Name;
	}


	public void setBshop_Name(String bshop_Name) {
		this.bshop_Name = bshop_Name;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLng() {
		return lng;
	}


	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
}
