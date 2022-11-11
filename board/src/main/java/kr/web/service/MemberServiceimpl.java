package kr.web.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.web.mapper.MemberMapper;
import kr.web.vo.MemberVO;

@Service
public class MemberServiceimpl implements MemberService{
	
	
	@Inject
	private MemberMapper mapper;
	
	@Override
	public List<MemberVO> memberlistAll(){
		return mapper.memberlist();
	}
	
	@Override
	public void register(MemberVO vo) {
		mapper.joinInsert(vo);
		
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return mapper.loginSelect(vo);
	}

	@Override
	public void update(MemberVO vo) {
		mapper.updateInfo(vo);
		
	}

	@Override
	public MemberVO idCheck(String id) {
		return mapper.idCheck(id);
	}

	@Override
	public void withdraw(MemberVO vo) {
		
	}

	
}
