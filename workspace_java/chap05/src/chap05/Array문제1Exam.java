package chap05;

public class Array문제1Exam {

	public static void main(String[] args) {
//			int max =0;
		int[] array = { 1, 5, 3, 8, 2 };

		// 문제 4.
		// 주어진 배열에서 최대값 찾기
		// 전략 : 배열의 첫번째 값부터 혹은 절대 나올 수 없는 최저치를 기준으로
		// 기준과 비교해서
		// 큰 값을 새로운 기준으로 정한다
		// 그렇게 살아남은 값이 최대값!

		int[] array2 = { 1, 5, 3, 8, 2, 9, 3 };
		int max = Integer.MIN_VALUE; // int가 가질 수 있는 최소값, 최대값은 MAX_VALUE가 있음
		for (int i = 0; i < array2.length; i++) {
			if (array2[i] > max) {
				max = array2[i];
			}

		}
		System.out.println("최대값 : " + max);

//			배열의 예 : {1, 5, 2, 4}
//			1. 배열 뒤집기: {4, 2, 5, 1}
//			2. 첫번째 자리에 0 넣기: {0, 1, 5, 2, 4}
//			3. 마지막 숫자를 첫번째에 넣기 (회전하는 느낌) : {4, 1, 5, 2}
		
//			{3,4,7,5,1,4,6,4,5}
//		4. 홀/짝수의 각각 개수를 출력
//		5. 주어진 수(예를 들어 4)보다 큰 숫자의 개수

//		여기서 부터 조금 어려운 문제
		
//		6. 두번째 최대값
//		7. 내림차순으로 정렬(큰수부터 작은 수 순으로)
		
//		로또 6개 번호 (1~45)
//		8. 중복되지 않게 숫자 선정
		
//		9. 자리 예약
//		자리가 10개 있는 소극장 예약 시스템을 만들자
//		1~10(또는 0~9)번까지 번호의 자리가 있음
//		예약할 자리는? 하고 입력 받음
//		1-1) 예약이 가능하면 "예약했습니다"
//		1-2) 예약 불가능 하면 "이미 예약되어있습니다"
//		2) 모든 자리의 예약 가능 여부 출력
//		3) 예약 가능한 자리만 출력
		
//		10. 임시비밀번호 8자리 만들기
//			1) 모두다 숫자로 
//			2) 모두다 소문자로(hint: char ascii)
//			3) 숫자 2개 이상, 대문자 1개 이상, 소문자 1개 이상 조합
	}
}