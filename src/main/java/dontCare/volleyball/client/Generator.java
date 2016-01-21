package dontCare.volleyball.client;

import java.util.ArrayList;

import dontCare.volleyball.client.dao.MemberJson;
import dontCare.volleyball.shared.Degree;
import dontCare.volleyball.shared.MemberImpl;
import dontCare.volleyball.shared.Office;
import dontCare.volleyball.shared.Role;

//Delete 暫時的，趕快改成 online-editor 吧 Orz
public class Generator {
	public static String member() {
		ArrayList<MemberImpl> list = new ArrayList<>();
		list.add(gen("5", "許濠麒", "小皮", 102,	"傳管", Role.outside, Office.captain));
		list.add(gen("11", "謝孟峯", "水哥",	102, "廣電", Role.setter));
		list.add(gen("8", "張如浩", "小浩", 102, "新聞", Role.middle));
		list.add(gen("12", "張景堯", "JINJIN", 102, "廣告", Role.middle));
		list.add(gen("17", "秦浩珉", "西門", 103, "廣告", Role.opposite));
		list.add(gen("16", "林峻霖", "",	103, "廣電",	Role.outside));
		list.add(gen("9", "陳文慶", "阿慶", 103, "廣電", Role.middle));
		list.add(gen("6", "金立璿", "全力踹", 103, "新聞", Role.middle));
		list.add(gen("30", "王禎傅", "", 103, "傳管", Role.outside, Office.firstMate));
		list.add(gen("19", "李作鴻", "阿鴻", 103, "新聞", Role.middle));
		list.add(gen("28", "吳建弘", "",	104, "廣告", Role.outside));
		list.add(gen("25", "李冠葎", "", 104, "廣電", Role.outside));
		list.add(gen("27", "張博皓", "海盜", 104, "新聞", Role.outside));
		list.add(gen("24", "吳柏憲", "",	104, "廣電", Role.outside));
		list.add(gen("23", "謝宗翰", "棕熊", 104, "廣電", Role.setter));
		
		list.add(gen("00", "鄭筑云", "KELLY", 104, "新聞", null, Office.manager));
		list.add(gen("00", "陳詩宜", "詩詩", 104, "新聞", null, Office.manager));
		list.add(gen("00", "林諱君", "CINDY", 104, "新聞", null, Office.manager));
		
		list.add(gen("00", "？？？", "教練", 89, "嘴砲", Role.setter, Office.coach));
		return MemberJson.marshall(list);
	}
	
	private static MemberImpl gen(String number, String name, String nickname, int level, String department, Role role) {
		return gen(number, name, nickname, level, department, role, null);
	}
	
	private static MemberImpl gen(String number, String name, String nickname, int level, String department, Role role, Office office) {
		MemberImpl member = new MemberImpl();
		member.setId(UUID.uuid(8));
		member.setNumber(number);
		member.setName(name);
		member.setNickname(nickname);
		member.setDegree(Degree.bachelor);
		member.setLevel(level);
		member.setDepartment(department);
		member.setRole(role);
		member.setOffice(office);
		return member;
	}
}
