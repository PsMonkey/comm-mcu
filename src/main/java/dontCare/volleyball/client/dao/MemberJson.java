package dontCare.volleyball.client.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

import dontCare.volleyball.shared.Member;

public class MemberJson {
	private static Factory factory = GWT.create(Factory.class);
	
	public static List<Member> unmarshall(String json) {
		return AutoBeanCodex.decode(
			factory, MemberList.class, json
		).as().getList();
	}
	
	public static String marshall(List<Member> list) {
		MemberList temp = new MemberList() {
			ArrayList<Member> myList = new ArrayList<>();
			
			@Override
			public void setList(List<Member> list) {
				for (Member member : list) {
					myList.add(factory.genBean(member).as());
				}
			}
			
			@Override
			public List<Member> getList() {
				return myList;
			}
		};
		
		temp.setList(list);
		return AutoBeanCodex.encode(factory.genList(temp)).getPayload();
	}
}

interface MemberList {
	public void setList(List<Member> list);
	public List<Member> getList();
}

interface Factory extends AutoBeanFactory {
	AutoBean<MemberList> memberList();
	AutoBean<Member> genBean(Member foo);
	AutoBean<MemberList> genList(MemberList foo);
}
