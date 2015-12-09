package dontCare.volleyball.shared;

public enum Office {
	captain(0, "隊長"), firstMate(1, "副隊"), 
	manager(2, "經理"), coach(Integer.MAX_VALUE, "教練");
	
	private final int order;
	private final String name;
	
	Office(int order, String name) {
		this.order = order;
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public String getName() {
		return name;
	}
}
