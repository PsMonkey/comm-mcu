package dontCare.volleyball.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.AddEvent;
import com.sencha.gxt.widget.core.client.event.BeforeAddEvent;
import com.sencha.gxt.widget.core.client.event.BeforeRemoveEvent;
import com.sencha.gxt.widget.core.client.event.ContainerHandler;
import com.sencha.gxt.widget.core.client.event.RemoveEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import dontCare.volleyball.client.dao.DataCenter;
import dontCare.volleyball.client.dao.event.MemberEvent;
import dontCare.volleyball.client.dao.event.MemberHandler;
import dontCare.volleyball.shared.Degree;
import dontCare.volleyball.shared.Member;
import dontCare.volleyball.shared.Office;
import dontCare.volleyball.shared.Role;

public class PlayerPanel extends Composite implements Editor<Member>{
	interface PlayerEditorUiBinder extends UiBinder< Widget, PlayerPanel> {}
	private static PlayerEditorUiBinder uiBinder = GWT.create(PlayerEditorUiBinder.class);
	private final static MemberPA PA = GWT.create(MemberPA.class);

	@UiField(provided=true) static Grid<Member> list;
	@UiField VerticalLayoutContainer ver;
	@UiField TextButton add;
	
	public PlayerPanel() {
		list = new Grid<Member>(new ListStore<>(PA.id()), genColumnModel());
		list.getView().setForceFit(true);
		list.getSelectionModel().addSelectionHandler(new SelectionHandler<Member>() {

			@Override
			public void onSelection(SelectionEvent<Member> event) {
				if (ver.getWidgetCount() == 0) {
					PlayerEditor playerEditor = new PlayerEditor();
					ver.add(playerEditor);
					playerEditor.view(event.getSelectedItem());
				} else {
					PlayerEditor playerEditor = (PlayerEditor) ver.getWidget(0);
					playerEditor.view(event.getSelectedItem());
				}
			}
		});
		initWidget(uiBinder.createAndBindUi(this));
		this.setPixelSize(800, 800);
		DataCenter.addMemberHandler(new MemberHandler() {

			@Override
			public void onMember(MemberEvent event) {
				build(event.getData());
			}
		});
		DataCenter.wantMember();
		ver.addContainerHandler(new ContainerHandler() {

			@Override
			public void onRemove(RemoveEvent event) {
				add.setText("新增");
			}

			@Override
			public void onBeforeRemove(BeforeRemoveEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAdd(AddEvent event) {
				add.setText("取消");
			}

			@Override
			public void onBeforeAdd(BeforeAddEvent event) {
				// TODO Auto-generated method stub

			}
		});
	}
	
	@UiHandler("add")
	void onAdd(SelectEvent event){
		if (ver.getWidgetCount() == 0) {
			ver.add(new PlayerEditor());
		}else {
			ver.remove(0);
		}
	}
	
	@UiHandler("export")
	void onExport(SelectEvent event){
		
	}
	
	private static ColumnModel<Member> genColumnModel() {
		ArrayList<ColumnConfig<Member, ?>> list = new ArrayList<>();
		list.add(new ColumnConfig<Member, String>(PA.number(), 60, "背號"));
		list.add(new ColumnConfig<Member, String>(PA.name(), 60, "姓名"));
		list.add(new ColumnConfig<Member, String>(PA.nickname(), 60, "暱稱"));
		list.add(new ColumnConfig<Member, Degree>(PA.degree(), 60, "学位"));
		list.add(new ColumnConfig<Member, Integer>(PA.level(), 60, "級數"));
		list.add(new ColumnConfig<Member, String>(PA.department(), 60, "系"));
		list.add(new ColumnConfig<Member, Role>(PA.role(), 60, "位置"));
		list.add(new ColumnConfig<Member, Office>(PA.office(), 60, "職務"));
		list.add(new ColumnConfig<Member, Boolean>(PA.graduate(), 60, "是否毕业"));
		return new ColumnModel<Member>(list);
	}
	
	private void build(List<Member> data) {
		for (final Member member : data) {
			list.getStore().add(member);
		}
	}

	interface MemberPA extends PropertyAccess<Member> {
		ModelKeyProvider<Member> id();
		ValueProvider<Member, String> number();
		ValueProvider<Member, String> name();
		ValueProvider<Member, String> nickname();
		ValueProvider<Member, Degree> degree();
		ValueProvider<Member, Integer> level();
		ValueProvider<Member, String> department();
		ValueProvider<Member, Role> role();
		ValueProvider<Member, Office> office();
		ValueProvider<Member, Boolean> graduate();
		
	}
}