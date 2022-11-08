package kr.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	

	private int idx;
	@NonNull
	private String title;
	@NonNull
	private String contents;
	private int count;
	@NonNull
	private String writer;
	private String indate;
	
	

}
