package dontCare.volleyball.shared;


public class MemberImpl implements Member {
	private String id;
	private String number;
	private String name;
	private String nickname;
	private Degree degree;
	private Integer level;
	private String department;
	private Role role;
	private Office office;
	private Boolean graduate;
	
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String getNumber() {
		return number;
	}
	@Override
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getNickname() {
		return nickname;
	}
	@Override
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public Degree getDegree() {
		return degree;
	}
	@Override
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	@Override
	public Integer getLevel() {
		return level;
	}
	@Override
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Override
	public String getDepartment() {
		return department;
	}
	@Override
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public Role getRole() {
		return role;
	}
	@Override
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public Office getOffice() {
		return office;
	}
	@Override
	public void setOffice(Office office) {
		this.office = office;
	}
	@Override	
	public Boolean isGraduate() {
		return graduate;
	}
	@Override
	public void setGraduate(Boolean graduate) {
		this.graduate = graduate;
	}
}
