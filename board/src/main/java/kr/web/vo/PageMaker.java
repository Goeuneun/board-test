package kr.web.vo;

import lombok.Data;

@Data
public class PageMaker {

	private int total; // SQL의 결과로 나온 데이터의 전체 개수
	private int startPage;
	private int endPage;
	private boolean prev, next;
	// 끝 페이지 번호보다 많은 양의 데이터가 존재하면 뒤로(next) 갈 수 있어야됨
	private Criteria cri;
	
	private int rowNum;		// 행번호 출력을위한변수

	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
//	public void setTotal(int total) {
//		this.total = total;
//		calcData();
//	}

	public PageMaker(Criteria cri, int total) {
		this.total = total;
		this.cri = cri;
		// 끝페이지 구하는 식 : 페이지번호에서 10나누고 반올림후 십 곱함 -- >형변환
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0) * 10);
		// 시작페이지는 끝페이지 - 9
		this.startPage = endPage - 9;

		// 실제 끝페이지 : 전체데이터에서 1.0곱해 실수 만들고 반올림 후 페이지당보여줄 데이터개수로 나눔
		int realEndpage = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		// 끝페이지가 실제 끝보다 크다면 끝은 실제페이지로 변경
		if (realEndpage < endPage) {
			this.endPage = realEndpage;
		}

		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndpage;
		
		if(cri.getPageNum()==1) {
			this.rowNum = total;
		}else {
			
			this.rowNum = total - (cri.getPageNum()-1) * cri.getAmount();
		}
		//행번호출력함


	}


	// ceil 소수값 올리는 함수

//	private void calcData() {
//		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
//		startPage = (endPage - displayPageNum) + 1;
//		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
//		if (endPage > tempEndPage) {
//			endPage = tempEndPage;
//		}
//
//		prev = startPage == 1 ? false : true;
//		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
//	}

}