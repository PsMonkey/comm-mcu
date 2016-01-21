package dontCare.volleyball.client;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import dontCare.volleyball.client.ui.PlayerPanel;
import dontCare.volleyball.shared.MemberList;

public class VolleyballEP implements EntryPoint {
	public interface MemberListMapper extends ObjectMapper<MemberList>{}
	
	@Override
	public void onModuleLoad() {
		//RootPanel.get("player").add(new PlayerViewer());
		RootPanel.get("player").add(new PlayerPanel());
	}
}
