package board.web.service;

import java.util.List;

import kr.web.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> boardlist() throws Exception;

	public BoardVO boardContent(int idx) throws Exception;

	public void boardInsert(BoardVO vo) throws Exception;

	public void boardUpdate(BoardVO vo) throws Exception;

	public void boardDelete(int idx) throws Exception;

	public void countUpdate(int idx) throws Exception;

}
