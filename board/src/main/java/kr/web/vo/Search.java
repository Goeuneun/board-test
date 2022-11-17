package kr.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Search extends Paging{

	private String searchType;
	private String keyword;
	
}