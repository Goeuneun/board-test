package kr.web.vo;

public class Criteria {

	private int pageNum; // 현재 페이지의 번호
	private int amount; // 한페이지당 보여줄 데이터양
	private int skip; // 스킵할 페이지 (MySQL limit 구문에서 필요함)
	private String keyword;		//검색키워드
	private String type;		//
	private String[] typeArr;
	

	// 기본값 생성자 세팅
	public Criteria() {
		this(1, 10);
		this.skip=0;

	}

	// 원하는 페이지와 보여질 개수
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum - 1) * amount;

	}

	public int getPageNum() {
		return pageNum;
	}

		
	//페이지 변경시 스킵값도 변경되어야함
	
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