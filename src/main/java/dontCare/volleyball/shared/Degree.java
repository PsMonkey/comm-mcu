package dontCare.volleyball.shared;

public enum Degree {
	bachelor(0,"学士"), master(1,"硕士"), doctor(2,"博士");
	private final String name;
	private final Integer order;

	private Degree(Integer order,String name) {
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
