package kr.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paging {

	private int viewPage = 1;	//���������� (1�� �ʱ�ȭ)
	private int total; // ��ü������ ����
	private int totalPage; // ��ü ����������

	private int viewPageCnt = 10; // ������ ������ ���� ���������
	// �⺻ �� ����
	private int startIndex = 1;
	private int endIndex = 10;		//������ �Խñ۰���
	// 1������ �������� 1 idx ~ 10, 2������ 11~ 20 �̷��� �����ߵ�

	private int range; // �������� �� ������ ���� 
	private int startPage; // �������� ���� ���۹�ȣ
	private int endPage; // �������� ����ȣ
	
	private int pageCnt; // ��ü����������
	private int rowNo; // �Խ��� ù ���ȣ
	private boolean prev; // ��������������
	private boolean next; // ��������������
	
	private int startList; //�Խñ۽��۹�ȣ��
	

	public void pageInfo(int viewPage, int range, int total) {
		this.viewPage = viewPage;
		this.range = range;
		this.total = total;
		
		// ��ü �������� - �Ǽ��� ����� �ݿø� �� ������ ��ȯ
		this.totalPage = (int) Math.ceil((double) total / viewPageCnt);
		
		// ���� ������
		this.startPage = (range - 1) * viewPageCnt + 1;
		
		// �� ������ ��ȣ ���ϱ�
		this.endPage = range * viewPageCnt;

		
		//�Խ��� ���۹�ȣ (MySQL limit 0���� �ؾߵǱⶫ��)
		this.startList = (viewPage - 1) * endIndex;
		
		// �ش��������� �Խ��� ���ȣ 
		this.rowNo = total -  (viewPage - 1) * endIndex;

		// ���� ��ư ���� -- 1�������϶��� ��Ȱ��ȭ
		this.prev = range == 1 ? false : true;

		// ���� ��ư ����
		this.next = endPage > totalPage ? false : true;
		if (this.endPage > this.totalPage) {
			this.endPage = this.totalPage;
			this.next = false;
		}

	}

}
