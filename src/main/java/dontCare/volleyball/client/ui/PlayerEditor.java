package dontCare.volleyball.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;

import dontCare.volleyball.shared.Member;

public class PlayerEditor extends Composite implements Editor<Member> {
	private static PlayerEditorUiBinder uiBinder = GWT.create(PlayerEditorUiBinder.class);
	interface PlayerEditorUiBinder extends UiBinder<Widget, PlayerEditor> {}
	
	interface Driver extends SimpleBeanEditorDriver<Member, PlayerEditor> {}
	private Driver driver = GWT.create(Driver.class);

	public PlayerEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
	}

}
