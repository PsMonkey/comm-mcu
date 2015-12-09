package dontCare.volleyball.client.ui;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.container.Container;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import dontCare.volleyball.client.dao.DataCenter;
import dontCare.volleyball.client.dao.event.MemberEvent;
import dontCare.volleyball.client.dao.event.MemberHandler;
import dontCare.volleyball.client.ui.component.Avatar;
import dontCare.volleyball.shared.Member;

public class PlayerViewer extends Composite {
	interface PlayerViewerUiBinder extends UiBinder< Widget, PlayerViewer> {}
	private static PlayerViewerUiBinder uiBinder = GWT.create(PlayerViewerUiBinder.class);

	@UiField FlowLayoutContainer list;
	@UiField Container infoPanel;
	@UiField Avatar avatar;
	@UiField LabelToolItem name;
	@UiField LabelToolItem nickname;
	@UiField LabelToolItem depLevel;
	@UiField LabelToolItem role;
	@UiField LabelToolItem office;
	
	
	public PlayerViewer() {
		initWidget(uiBinder.createAndBindUi(this));
		this.setPixelSize(800, 400);
		DataCenter.addMemberHandler(new MemberHandler() {
			@Override
			public void onMember(MemberEvent event) {
				build(event.getData());
			}
		});
		
		DataCenter.wantMember();
	}

	private void build(List<Member> data) {
		for (final Member member : data) {
			final Avatar image = new Avatar();
			image.setId(member.getId());
			image.setPixelSize(80, 80);
			image.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					showInfo(member);
				}
			});
			list.add(image, new MarginData(1));
		}
	}
	
	private void showInfo(Member member) {
		infoPanel.setVisible(true);
		avatar.setVisible(true);
		avatar.setId(member.getId());
		name.setLabel(member.getName());
		nickname.setLabel(member.getNickname());
		depLevel.setLabel(member.getDepartment() + " " + member.getLevel() + " 級");
		role.setLabel(member.getRole() == null ? "" : member.getRole().getName());
		office.setLabel(member.getOffice() == null ? "" : member.getOffice().getName());
	}
}