package dontCare.volleyball.client.dao;

import java.util.List;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.shared.GWT;

import dontCare.volleyball.shared.MemberImpl;
import dontCare.volleyball.shared.MemberList;

public class MemberJson {
	public static interface MemberListMapper extends ObjectMapper<MemberList>{}
	
	public static List<MemberImpl> unmarshall(String json) {
		MemberListMapper mapper = GWT.create(MemberListMapper.class);
		MemberList list = mapper.read(json);
		return list.getList();
	}
	
	public static String marshall(List<MemberImpl> list) {
		MemberListMapper mapper = GWT.create(MemberListMapper.class);
		MemberList memberList = new MemberList();
		memberList.setList(list);
		return mapper.write(memberList);
	}
}


