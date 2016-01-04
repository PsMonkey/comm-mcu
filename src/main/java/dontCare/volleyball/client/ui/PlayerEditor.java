package dontCare.volleyball.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.IntegerField;
import com.sencha.gxt.widget.core.client.form.TextField;

import dontCare.volleyball.client.UUID;
import dontCare.volleyball.shared.Degree;
import dontCare.volleyball.shared.Member;
import dontCare.volleyball.shared.MemberImpl;
import dontCare.volleyball.shared.Office;
import dontCare.volleyball.shared.Role;

public class PlayerEditor extends Composite implements Editor<Member> {
	private static PlayerEditorUiBinder uiBinder = GWT.create(PlayerEditorUiBinder.class);
	private static DegreeProperty degreeProperties = GWT.create(DegreeProperty.class);
	private static RoleProperty roleProperties = GWT.create(RoleProperty.class);
	private static OfficeProperty officeProperties = GWT.create(OfficeProperty.class);
	
	interface PlayerEditorUiBinder extends UiBinder<Widget, PlayerEditor> {}
	
	interface Driver extends SimpleBeanEditorDriver<Member, PlayerEditor> {}
	private Driver driver = GWT.create(Driver.class);

	@UiField TextField number;
	@UiField TextField name;
	@UiField TextField nickname;
	@UiField(provided = true) ComboBox<Degree> degree;
	@UiField IntegerField level;
	@UiField TextField department;
	@UiField(provided=true) ComboBox<Role> role;
	@UiField(provided=true) ComboBox<Office> office;
	@UiField CheckBox graduate;
	
	public PlayerEditor() {
		degree = new ComboBox<>(new ListStore<Degree>(degreeProperties.id()),degreeProperties.name());
		role = new ComboBox<>(new ListStore<Role>(roleProperties.id()),roleProperties.name());
		office = new ComboBox<>(new ListStore<Office>(officeProperties.id()),officeProperties.name());
		initDegree();
		initOffice();
		initRole();
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		onReset(null);
	}
	
	@UiHandler("save")
	void onSave(SelectEvent s){
		final Member member = driver.flush();
		if (member.getId() != null && !member.getId().equals("")) {
			PlayerPanel.list.getStore().update(member);
		}else{
			member.setId(UUID.uuid(8));
			PlayerPanel.list.getStore().add(member);
		}
		onReset(null);
	}
	
	@UiHandler("reset")
	void onReset(SelectEvent s){
		MemberImpl member = new MemberImpl();
		driver.edit(member);
	}
	
	@UiHandler("delete")
	void onDelete(SelectEvent s){
		Member member = driver.flush();
		PlayerPanel.list.getStore().remove(member);
		onReset(null);
	}
	
	public void view(Member member){
		driver.edit(member);
	}
	
	private void initDegree(){
		for (Degree d : Degree.values()) {
			degree.getStore().add(d);
		}
	}
	
	private void initRole(){
		for (Role r : Role.values()) {
			role.getStore().add(r);
		}
	}
	
	private void initOffice(){
		for (Office o : Office.values()) {
			office.getStore().add(o);
		}
	}
	
	interface DegreeProperty extends PropertyAccess<Degree> {
		@Path("order")
		ModelKeyProvider<Degree> id();

		LabelProvider<Degree> name();
	}
	
	interface RoleProperty extends PropertyAccess<Role> {
		@Path("order")
		ModelKeyProvider<Role> id();

		LabelProvider<Role> name();
	}
	
	interface OfficeProperty extends PropertyAccess<Office> {
		@Path("order")
		ModelKeyProvider<Office> id();

		LabelProvider<Office> name();
	}
}
