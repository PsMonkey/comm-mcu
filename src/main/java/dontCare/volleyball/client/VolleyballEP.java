package dontCare.volleyball.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import dontCare.volleyball.client.ui.PlayerViewer;

public class VolleyballEP implements EntryPoint {
	@Override
	public void onModuleLoad() {
		RootPanel.get("player").add(new PlayerViewer());
	}
}
