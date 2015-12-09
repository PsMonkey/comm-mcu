package dontCare.volleyball.shared;

import java.util.Comparator;

public interface Member {

	String getId();

	void setId(String id);

	String getNumber();

	void setNumber(String number);

	String getName();

	void setName(String name);

	String getNickname();

	void setNickname(String nickname);

	Degree getDegree();

	void setDegree(Degree degree);

	Integer getLevel();

	void setLevel(Integer level);

	String getDepartment();

	void setDepartment(String department);

	Role getRole();

	void setRole(Role role);

	Office getOffice();

	void setOffice(Office office);

	Boolean isGraduate();

	void setGraduate(Boolean graduate);
	
	class DefaultComparator implements Comparator<Member> {
		@Override
		public int compare(Member o1, Member o2) {
			if (o1.getOffice() != o2.getOffice()) {
				return o1.getOffice().compareTo(o2.getOffice());
			}
			
			return o1.getLevel().compareTo(o2.getLevel());
		}
	}
}