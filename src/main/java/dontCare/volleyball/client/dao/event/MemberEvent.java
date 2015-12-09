package dontCare.volleyball.client.dao.event;

import java.util.List;

import dontCare.volleyball.client.dao.DataCenter.DataEvent;
import dontCare.volleyball.shared.Member;

public class MemberEvent extends DataEvent< MemberHandler> {
	public static final Type< MemberHandler> TYPE = new Type< MemberHandler>();
	private final List<Member> data;
	
	public MemberEvent(List<Member> data) {
		this.data = data;
	}
	
	@Override
	public Type< MemberHandler> getAssociatedType() {
		return TYPE;
	}
	
	@Override
	protected void dispatch(MemberHandler handler) {
		handler.onMember(this);
	}

	public List<Member> getData() {
		return data;
	}
}