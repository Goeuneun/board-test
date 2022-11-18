package kr.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.web.vo.BoardVO;
import kr.web.vo.Criteria;
import kr.web.vo.Paging;
import kr.web.vo.Search;

@Mapper
public interface BoardMapper {

	public List<BoardVO> boardlist();
	// ���� �� ������

	public BoardVO boardContent(int idx);
	// Ư����

	public void boardInsert(BoardVO vo);

	public void boardUpdate(BoardVO vo);

	public void boardDelete(int idx);

	public void countUpdate(int idx);
	
	public List<BoardVO> listpage(int page);

	public List<BoardVO> listCriteria(Criteria cri);	
	//���������´� ����Ʈ������
	
	public int countPaging(Criteria cri) throws Exception;

	public int boardTotal(Criteria cri);
	// ��ü �Խñ� - ���͸��� �������� �Ű����� �߰�

	public List<BoardVO> paginList(Search search);
	

}
