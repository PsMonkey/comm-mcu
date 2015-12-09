package dontCare.volleyball.client.ui.component;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

public class Avatar extends Image {
	public interface Resources extends ClientBundle {
		@Source("wanted.jpg")
		ImageResource defaultImage();
	}
	private static final Resources resources = GWT.create(Resources.class);
	
	public Avatar() {
		this.getElement().getStyle().setCursor(Cursor.POINTER);
		this.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				setResource(resources.defaultImage());
			}
		});
	}
	
	public void setId(String id) {
		this.setUrl("avatar/" + id + ".jpg");
	}
}