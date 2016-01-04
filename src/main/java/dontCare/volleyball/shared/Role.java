package dontCare.volleyball.shared;

public enum Role {
	setter(0,"舉球"), libero(1,"自由"), middle(2,"攔中"), outside(3,"大砲"), opposite(4,"副舉");
	
	private final String name;
	private final Integer order;

	private Role(Integer order,String name) {
		this.order = order;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getOrder() {
		return order;
	}
}
