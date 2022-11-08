package kr.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.web.vo.BoardVO;

@Mapper
public interface BoardMapper {

	public List<BoardVO> boardlist();

	public BoardVO boardContent(int idx);

	public void boardInsert(BoardVO vo);

	public void boardUpdate(BoardVO vo);

	public void boardDelete(int idx);

	public void countUpdate(int idx);

}
