package kr.web.vo;

import lombok.Data;

@Data
public class PageMaker {

	private int total; // SQL�� ����� ���� �������� ��ü ����
	private int startPage;
	private int endPage;
	private boolean prev, next;
	// �� ������ ��ȣ���� ���� ���� �����Ͱ� �����ϸ� �ڷ�(next) �� �� �־�ߵ�
	private Criteria cri;
	
	private int rowNum;		// ���ȣ ��������Ѻ���

	
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
		// �������� ���ϴ� �� : ��������ȣ���� 10������ �ݿø��� �� ���� -- >����ȯ
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0) * 10);
		// ������������ �������� - 9
		this.startPage = endPage - 9;

		// ���� �������� : ��ü�����Ϳ��� 1.0���� �Ǽ� ����� �ݿø� �� �������纸���� �����Ͱ����� ����
		int realEndpage = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		// ���������� ���� ������ ũ�ٸ� ���� ������������ ����
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
		//���ȣ�����


	}


	// ceil �Ҽ��� �ø��� �Լ�

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