package kr.web.service;

import java.util.List;

import kr.web.vo.MemberVO;

public interface MemberService {
	
	public List<MemberVO> memberlistAll();
	
	public void register(MemberVO vo);
	
	public MemberVO login(MemberVO vo);
	
	public void update(MemberVO vo);
	
	public MemberVO idCheck(String id);
	
	public void withdraw(MemberVO vo);
	

}
