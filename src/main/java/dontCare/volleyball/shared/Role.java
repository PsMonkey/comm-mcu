package dontCare.volleyball.shared;

public enum Role {
	setter("舉球"), libero("自由"), middle("攔中"), outside("大砲"), opposite("副舉");
	
	private final String name;

	private Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
