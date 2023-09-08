package board.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPaging {
	// 페이징 처리를 위한 변수들
	private int currentPage; // 현재페이지
	private int pageBlock;	 // [이전][1][2][3][다음] -> 일때 pageBlock은 3
	private int pageSize; 	 // 1페이지당 5개씩
	private int totalA;  	 // 총글수
	private StringBuffer pagingHTML; // 페이징 처리를 입력받을 변수
	
	public void makePagingHTML() {
		// 페이징 만들기 :
		// * [이전][1][2][3][다음] - 3페이지씩 잘랐을 때 아래와 같은 3가지 경우의 수가 생긴다.
		// [이전] [4] [5]
		// [이전] [4] [5] [6]
		// [이전] [4] [5] [6] [다음]
		// 이러한 로직을 처리하는 곳이 이 메소드
		pagingHTML = new StringBuffer();
		
		// 변수 계산 로직
		int totalP = (totalA + pageSize-1) / pageSize; // 총 페이지 수
		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;  // 시작 페이지 [1]
		int endPage = startPage + pageBlock -1; // 끝 페이지 [3]
		
		if(endPage > totalP) endPage = totalP; // ???
		
		// 페이지 출력 로직
		if(startPage != 1) // [이전]
			pagingHTML.append("<span id='paging' onclick='boardPaging(" + (startPage-1) + ")'>[이전]</span>"); // <span>딱 이 영역만큼한 태그 잡아줌 (a태그를 대신 써도 된다.)
		
		for(int i=startPage; i <=endPage; i++) { // [1][2][3]
			if(i == currentPage) {
				pagingHTML.append("<span id='currentPaging' onclick='boardPaging(" + i + ")'>" + i + "</span>");
			} else {
				pagingHTML.append("<span id='paging' onclick='boardPaging(" + i + ")'>" + i + "</span>");
			}
		} //for
		
		if(endPage < totalP) // [다음]
			pagingHTML.append("<span id='paging' onclick='boardPaging(" + (endPage+1) + ")'>[다음]</span>");
	}
}
