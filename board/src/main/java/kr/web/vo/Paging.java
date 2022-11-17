package kr.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paging {

	private int viewPage = 1;	//현재페이지 (1로 초기화)
	private int total; // 전체데이터 개수
	private int totalPage; // 전체 페이지개수

	private int viewPageCnt = 10; // 보여줄 페이지 범위 페이지목록
	// 기본 값 세팅
	private int startIndex = 1;
	private int endIndex = 10;		//보여줄 게시글개수
	// 1페이지 눌렀을때 1 idx ~ 10, 2페이지 11~ 20 이렇게 보여야됨

	private int range; // 보여지는 각 페이지 범위 
	private int startPage; // 각페이지 범위 시작번호
	private int endPage; // 각페이지 끝번호
	
	private int pageCnt; // 전체페이지범위
	private int rowNo; // 게시판 첫 행번호
	private boolean prev; // 이전페이지여부
	private boolean next; // 다음페이지여부
	
	private int startList; //게시글시작번호임
	

	public void pageInfo(int viewPage, int range, int total) {
		this.viewPage = viewPage;
		this.range = range;
		this.total = total;
		
		// 전체 페이지수 - 실수로 만들어 반올림 후 정수형 변환
		this.totalPage = (int) Math.ceil((double) total / viewPageCnt);
		
		// 시작 페이지
		this.startPage = (range - 1) * viewPageCnt + 1;
		
		// 끝 페이지 번호 구하기
		this.endPage = range * viewPageCnt;

		
		//게시판 시작번호 (MySQL limit 0부터 해야되기땜에)
		this.startList = (viewPage - 1) * endIndex;
		
		// 해당페이지에 게시판 행번호 
		this.rowNo = total -  (viewPage - 1) * endIndex;

		// 이전 버튼 상태 -- 1페이지일때는 비활성화
		this.prev = range == 1 ? false : true;

		// 다음 버튼 상태
		this.next = endPage > totalPage ? false : true;
		if (this.endPage > this.totalPage) {
			this.endPage = this.totalPage;
			this.next = false;
		}

	}

}
