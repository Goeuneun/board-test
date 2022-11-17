package kr.web.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.web.mapper.BoardMapper;
import kr.web.vo.BoardVO;
import kr.web.vo.Criteria;
import kr.web.vo.Paging;
import kr.web.vo.Search;

@Service
@Component
public class BoardServiceimpl implements BoardService {

	@Inject
	private BoardMapper mapper;

	@Override
	public void create(BoardVO vo) throws Exception {
		mapper.boardInsert(vo);

	}

	@Override
	public BoardVO read(int idx) throws Exception {
		return mapper.boardContent(idx);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		mapper.boardUpdate(vo);

	}

	@Override
	public void updateCnt(int idx) throws Exception {
		mapper.countUpdate(idx);
	}

	@Override
	public void delete(int idx) throws Exception {
		mapper.boardDelete(idx);

	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return mapper.boardlist();
	}

	@Override
	public List<BoardVO> listpage(int page) {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return mapper.listpage(page);
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		return mapper.listCriteria(cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return mapper.countPaging(cri);
	}

	@Override
	public int boardTotal() {
		return mapper.boardTotal();
	}

	@Override
	public List<BoardVO> paginList(Search search) throws Exception {
		return mapper.paginList(search);
	}
}
