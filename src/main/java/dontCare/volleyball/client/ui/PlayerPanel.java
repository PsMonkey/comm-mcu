package dontCare.volleyball.client.ui;

import java.util.ArrayList;

import com.google.gwt.aria.client.Role;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import dontCare.volleyball.shared.Degree;
import dontCare.volleyball.shared.Member;
import dontCare.volleyball.shared.Office;

public class PlayerPanel extends Composite {
	interface PlayerEditorUiBinder extends UiBinder< Widget, PlayerPanel> {}
	private static PlayerEditorUiBinder uiBinder = GWT.create(PlayerEditorUiBinder.class);
	private final static MemberPA PA = GWT.create(MemberPA.class);

	@UiField(provided=true) Grid<Member> list;
	
	public PlayerPanel() {
		list = new Grid<Member>(
			new ListStore<>(PA.id()), 
			genColumnModel()
		);
		initWidget(uiBinder.createAndBindUi(this));
		this.setPixelSize(800, 800);
	}
	
	private static ColumnModel<Member> genColumnModel() {
		ArrayList<ColumnConfig<Member, ?>> list = new ArrayList<>();
		list.add(new ColumnConfig<Member, String>(PA.number(), 60, "背號"));
		list.add(new ColumnConfig<Member, String>(PA.name(), 60, "姓名"));
		list.add(new ColumnConfig<Member, String>(PA.nickname(), 60, "暱稱"));
		list.add(new ColumnConfig<Member, Degree>(PA.degree(), 60, ""));
		list.add(new ColumnConfig<Member, Integer>(PA.level(), 60, "級數"));
		return new ColumnModel<Member>(list);
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