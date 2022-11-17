package kr.web.vo;

public class Criteria {

	private int pageNum; // ���� �������� ��ȣ
	private int amount; // ���������� ������ �����;�
	private int skip; // ��ŵ�� ������ (MySQL limit �������� �ʿ���)
	private String keyword;		//�˻�Ű����
	private String type;		//
	private String[] typeArr;
	

	// �⺻�� ������ ����
	public Criteria() {
		this(1, 10);
		this.skip=0;

	}

	// ���ϴ� �������� ������ ����
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum - 1) * amount;

	}

	public int getPageNum() {
		return pageNum;
	}

		
	//������ ����� ��ŵ���� ����Ǿ����
	
	public void setPageNum(int pageNum) {
		this.skip = (pageNum - 1) * this.amount;
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
	}

	public String[] getTypeArr() {
		return typeArr;
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}


}