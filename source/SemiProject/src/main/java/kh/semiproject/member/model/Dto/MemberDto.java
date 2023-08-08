package kh.semiproject.member.model.Dto;

public class MemberDto {
	private String member_Id;
	private String member_Pwd;
	private String member_Name;
	private String member_Tel;
	private String member_Email;
	private int member_Type;
	private String bs_Number;
	private String bs_Manager;
	
	public MemberDto() {
		
	}
	// 사업자 회원가입 기능
	public MemberDto(String member_Id, String member_Pwd, String member_Name, String member_Tel, String member_Email,
			int member_Type, String bs_Number, String bs_Manager) {
		super();
		this.member_Id = member_Id;
		this.member_Pwd = member_Pwd;
		this.member_Name = member_Name;
		this.member_Tel = member_Tel;
		this.member_Email = member_Email;
		this.member_Type = member_Type;
		this.bs_Number = bs_Number;
		this.bs_Manager = bs_Manager;
	}
	// 일반 회원가입 기능
	public MemberDto(String member_Id, String member_Pwd, String member_Name, String member_Tel, String member_Email,
			int member_Type) {
		this.member_Id = member_Id;
		this.member_Pwd = member_Pwd;
		this.member_Name = member_Name;
		this.member_Tel = member_Tel;
		this.member_Email = member_Email;
		this.member_Type = member_Type;
	}
	// 로그인 기능
	public MemberDto(String member_Id, String member_Pwd) {
		this.member_Id = member_Id;
		this.member_Pwd = member_Pwd;
	}
	@Override
	public String toString() {
		return "MemberDto [member_Id=" + member_Id + ", member_Pwd=" + member_Pwd + ", member_Name=" + member_Name
				+ ", member_Tel=" + member_Tel + ", member_Email=" + member_Email + ", member_Type=" + member_Type
				+ ", bs_Number=" + bs_Number + ", bs_Manager=" + bs_Manager + "]";
	}
	public String getMember_Id() {
		return member_Id;
	}
	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}
	public String getMember_Pwd() {
		return member_Pwd;
	}
	public void setMember_Pwd(String member_Pwd) {
		this.member_Pwd = member_Pwd;
	}
	public String getMember_Name() {
		return member_Name;
	}
	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}
	public String getMember_Tel() {
		return member_Tel;
	}
	public void setMember_Tel(String member_Tel) {
		this.member_Tel = member_Tel;
	}
	public String getMember_Email() {
		return member_Email;
	}
	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}
	public int getMember_Type() {
		return member_Type;
	}
	public void setMember_Type(int member_Type) {
		this.member_Type = member_Type;
	}
	public String getBs_Number() {
		return bs_Number;
	}
	public void setBs_Number(String bs_Number) {
		this.bs_Number = bs_Number;
	}
	public String getBs_Manager() {
		return bs_Manager;
	}
	public void setBs_Manager(String bs_Manager) {
		this.bs_Manager = bs_Manager;
	}
	
	
	
	
	
	
	
}
