package kh.semiproject.board.model.vo;

public class BoardDto {
	private int bno;
	private String bsNumber;
	private String btitle;
	private String bcontent;
	private String bwriteDate;
	private String bwriter;
	private String baddress;
	private String btel;
	private String bshopName;
	private double lat;
	private double lng;
	
	
	public BoardDto() {
		
	}
	// 게시글리스트 확인
	public BoardDto(int bno, String btitle, String bwriteDate, String bwriter) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bwriteDate = bwriteDate;
		this.bwriter = bwriter;
	}
	// 게시글 상세보기
	public BoardDto(int bno, String btitle, String bcontent, String bwriteDate, String bwriter, String baddress,
			String btel, String bshopName) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriteDate = bwriteDate;
		this.bwriter = bwriter;
		this.baddress = baddress;
		this.btel = btel;
		this.bshopName = bshopName;
	}
	
	// 가게등록 게시글 작성
	public BoardDto(String bsNumber, String btitle, String bcontent, String bwriteDate, String bwriter, String baddress,
			String btel, String bshopName, double lat, double lng) {
		super();
		this.bsNumber = bsNumber;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriteDate = bwriteDate;
		this.bwriter = bwriter;
		this.baddress = baddress;
		this.btel = btel;
		this.bshopName = bshopName;
		this.lat = lat;
		this.lng = lng;
	}
	
	public BoardDto(int bno, String bsNumber, String btitle, String bcontent, String bwriteDate, String bwriter,
			String baddress, String btel, String bshopName, double lat, double lng) {
		this.bno = bno;
		this.bsNumber = bsNumber;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriteDate = bwriteDate;
		this.bwriter = bwriter;
		this.baddress = baddress;
		this.btel = btel;
		this.bshopName = bshopName;
		this.lat = lat;
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", bsNumber=" + bsNumber + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", bwriteDate=" + bwriteDate + ", bwriter=" + bwriter + ", baddress=" + baddress + ", btel=" + btel
				+ ", bshopName=" + bshopName + ", lat=" + lat + ", lng=" + lng + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBsNumber() {
		return bsNumber;
	}

	public void setBsNumber(String bsNumber) {
		this.bsNumber = bsNumber;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriteDate() {
		return bwriteDate;
	}

	public void setBwriteDate(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBaddress() {
		return baddress;
	}

	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public String getBtel() {
		return btel;
	}

	public void setBtel(String btel) {
		this.btel = btel;
	}

	public String getBshopName() {
		return bshopName;
	}

	public void setBshopName(String bshopName) {
		this.bshopName = bshopName;
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
