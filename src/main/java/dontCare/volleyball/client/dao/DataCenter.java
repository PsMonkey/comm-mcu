package dontCare.volleyball.client.dao;

import java.util.List;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

import dontCare.volleyball.client.dao.event.MemberEvent;
import dontCare.volleyball.client.dao.event.MemberHandler;
import dontCare.volleyball.shared.MemberImpl;

public class DataCenter {
	public static abstract class DataEvent<H extends DataEventHandler> extends GwtEvent<H> {}
	public interface DataEventHandler extends EventHandler {}
	
	private static final SimpleEventBus eventBus = new SimpleEventBus();
	static void fireEvent(DataEvent<?> event) {
		eventBus.fireEvent(event);
	}
	
	// ==== Member 區 ==== //
	private static List<MemberImpl> memberList;
	private static MemberDao memberDao = new MemberDao();

	static {
		addMemberHandler(new MemberHandler() {
			@Override
			public void onMember(MemberEvent event) {
				memberList = event.getData();
			}
		});
	}

	public static HandlerRegistration addMemberHandler(MemberHandler h) {
		return eventBus.addHandler(MemberEvent.TYPE, h);
	}
		
	public static void wantMember() {
		memberDao.fetch();
	}
	
	public static List<MemberImpl> getPatientList() {
		return memberList;
	}
	// ======== //
}