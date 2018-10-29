package dao;

import VO.Member;

public interface MemberMapper {
	public Member login(Member vo);
	public int insertMember(Member vo);
	public int idcheck(String userid);
}
