package kr.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.web.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public List<MemberVO> memberlist();

	public void joinInsert(MemberVO vo);

	public MemberVO loginSelect(MemberVO vo);

	public void updateInfo(MemberVO vo);

	public MemberVO idCheck(String id);
	
	
	

}
