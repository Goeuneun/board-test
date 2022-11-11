package kr.web.service;

import java.util.List;

import kr.web.vo.BoardVO;

public interface BoardService {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(int idx) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void updateCnt(int idx) throws Exception;

	public void delete(int idx) throws Exception;

	public List<BoardVO> listAll() throws Exception;

}
