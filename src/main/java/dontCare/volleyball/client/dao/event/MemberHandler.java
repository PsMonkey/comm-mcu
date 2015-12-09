package dontCare.volleyball.client.dao.event;

import dontCare.volleyball.client.dao.DataCenter.DataEventHandler;

public interface MemberHandler extends DataEventHandler {
	public void onMember(MemberEvent event);
}