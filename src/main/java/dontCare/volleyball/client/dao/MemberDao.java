package dontCare.volleyball.client.dao;

import dontCare.volleyball.client.dao.event.MemberEvent;

public class MemberDao extends HtmlFetcher {
	@Override
	String fetchUrl() {
		return "member.json";
	}

	@Override
	void parseData(String json) {
		DataCenter.fireEvent(new MemberEvent(MemberJson.unmarshall(json)));
	}
}