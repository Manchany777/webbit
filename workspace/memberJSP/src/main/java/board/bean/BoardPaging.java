package board.bean;

public class BoardPaging {
	// 페이징 처리를 위한 변수들
	private int currentPage; // 현재페이지
	private int pageBlock;	 // [이전][1][2][3][다음]
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
		
		int totalP = (totalA + pageSize-1) / pageSize; // 총 페이지 수
	}
}
