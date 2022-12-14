package kr.web.vo;

public class Criteria {

	private int pageNum; // 현재 페이지의 번호
	private int amount; // 한페이지당 보여줄 데이터양
	private int skip; // 스킵할 페이지 (MySQL limit 구문에서 필요함)
	private String keyword;		//검색키워드
	private String type;		// 검색조건  제목, 작성자, 본문, 복합검색 등등
	private String[] typeArr;	
	// 타입변수에 데이터(검색조건)가 들어왔을때 배열형식으로 담음 

	// 기본값 생성자 세팅
	public Criteria() {
		this(1, 5);
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

	// TCW 와 같이 검색조건을 split함수로 쪼개서 배열에 넣어줌
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