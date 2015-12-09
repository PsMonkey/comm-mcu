package dontCare.volleyball.client.ui.component;

import com.google.gwt.dom.client.Style.Unit;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

public class Label extends LabelToolItem {
	public Label() {
		this.getElement().getStyle().setFontSize(20, Unit.PX);
	}
}
