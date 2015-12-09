package dontCare.volleyball.client.dao;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

abstract class HtmlFetcher {
	abstract String fetchUrl();
	abstract void parseData(String json);
	
	public void fetch() {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, makeUrl(fetchUrl()));
		try {
			builder.sendRequest(null, new RequestCallback() {
				@Override
				public void onError(Request request, Throwable exception) {
					handleException(exception);
				}

				@Override
				public void onResponseReceived(Request request, Response response) {
					if (200 != response.getStatusCode()) {
						handleNot200Status(response);
						return;
					}

					parseData(response.getText());
				}
			});
		} catch (RequestException e) {
			handleException(e);
		}
	}
	
	String makeUrl(String url) {
		return GWT.getHostPageBaseURL() + url;
	}
	
	String makeListJson(String json) {
		//如果完全沒資料，server side 回傳內容也會是空字串，所以要擋一下 Orz
		return "{\"list\":" + (json.isEmpty() ? "[]" : json) + "}";
	}
	
	void handleException(Throwable exception) {
		Window.alert(
			"資料讀取錯誤\n"
			+ exception.getMessage()
		);
	}
	
	void handleNot200Status(Response response) {
		Window.alert("restful API 回傳狀態錯誤\ncode : " + response.getStatusCode());
	}
}