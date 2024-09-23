package chap05;

import java.util.Scanner;

public class Array종합문제Exam {

	public static void main(String[] args) {

//		int[] array = { 1, 5, 2, 4 }; // 1번 문제
//		for(int i=array.length-1; i >= 0;i--)
//		System.out.println(array[i]);

//		int[] array2 = new int[(array.length)+1];  // 2번 문제
//		
//		for(int i=0; i<array.length; i++) {
//			
//			array2[i+1] = array[i];
//
//		}
//		
//		array2[0]= 0;
//		for(int i=0; i< array2.length; i++) {
//			
//			System.out.println(array2[i]);
//		}

//		int[] array2 = new int[array.length]; // 3번 문제
//		
//		for(int i=0; i<array.length-1; i++) {
//			
//			array2[i+1] = array[i];
//			array2[0] = array[3];
//		}
//		
//		for(int i=0; i< array2.length; i++) {
//			
//			System.out.println(array2[i]);
//		}

//		int[] array = {3,4,7,5,1,4,6,4,5}; // 4번 문제
//		int odd=0;
//		int even=0;
//		for(int i=0; i< array.length; i++) {
//			
//			if((array[i]%2) == 0) {
//				odd++;
//			} else if ((array[i]%2) == 1) {
//				even++;
//			}
//
//		}
//		System.out.println(odd);
//		System.out.println(even);

//		Scanner scan = new Scanner(System.in);

		int[] array = { 3, 4, 7, 5, 1, 4, 6, 4, 5 }; // 5번 문제
//		int big=0;
//		int small=0;
//		
//		int num;
//		System.out.println("숫자를 입력하세요");
//		num= scan.nextInt();
//		
//		for(int i=0; i< array.length; i++) {
//			
//			if(array[i] > num) {
//				big++;
//			} else if (array[i] < num) {
//				small++;
//			} 
//		}
//		System.out.println(num+"보다 큰 숫자는 " +big+"개 입니다");

//		int max = Integer.MIN_VALUE; // 6번 문제
//		int max2 = Integer.MIN_VALUE;
//		for (int i = 0; i < array.length; i++) {
//			if (array[i] > max) {
//				max = array[i];
//			}
//		}
//		
//		for(int i=0; i< array.length; i++) {
//		if(array[i]==max) {
//			array[i] = 0;
//			}
//		}
//		
//		for (int i = 0; i < array.length; i++) {
//			if (array[i] > max2) {
//				max2 = array[i];
//			}
//		}
//		System.out.println(max2);
		
//		int array2[] = new int[array.length]; array를 변형시켜서 오름 차순을 내림차순으로 변형시키려 했지만 부등호 방향을 바꾸는 걸로 해결 가능했음 
//		for(int i=0; i< array.length; i++) {    // 내림차순 7번 문제
//			for(int j = i+1; j< array.length; j++){
//				int tmp = 0;
//				if(array[i] > array[j]) {
//					tmp = array[i];
//					array[i] = array[j];
//					array[j] = tmp;
//				}
//			}
//		}
//		
//		for(int i=0; i< array.length; i++) {   
////			array2[i] = array[(array.length-1)-i]; 
//			System.out.println(array[i]);
//		}
		   
		
		int[] lotto = new int[6];						// 8번 문제
		for(int i=0; i< lotto.length; i++) {
			lotto[i] = (int) (Math.random()*45) +1 ;
		}
//		
		int[] lottery = new int [6];      // 잘못된 풀이
		
//		for (int i = 0; i < lotto.length; i++) {
//			for (int j = i+1; j < lotto.length; j++) {
//				if (lotto[i] == lotto[j]) {
//					continue;
//				} else {
//					lottery[i] = lotto[i];
//				}
//			}
//			System.out.println(lottery[i]);
//		}
		
//		for(int i = 0; i< lotto.length; i++){  // 0이 나오는 이유?
//			boolean a = false;
//			for(int j = 0; j< i; j++) {
//				if ( lotto[i] == lotto[j]) {
//					a = true;
//				}
//			} if ( a == false) {
//				lottery[i] = lotto[i];
//			}
//		}
//		
//		for (int i = 0; i < lottery.length; i++) {
//
//			System.out.println(i + " 번호 :" + lottery[i]);
//		}
//		
//		Scanner scan = new Scanner(System.in);			// 9번문제
//		System.out.println("예약할 자리는?");
//		int pos = scan.nextInt(); 
//		int[] ticket = new int[pos];
//		int[] array1 = new int[10];
//
//		for (int i = 0; i < ticket.length; i++) {
//			System.out.println("다시 한번 자리번호를 입력해 주세요");
//			ticket[i] = scan.nextInt();
//			System.out.println(ticket[i]);
//		}
//		
//		for(int i =0; i< ticket.length; i++) {
//			if( array1[i] == ticket[ticket.length-1]) {
//				System.out.println("이미 예약되어 있습니다");
//			} else if ( ticket[ticket.length-1]>10 || ticket[ticket.length-1]<1) {
//				System.out.println("예약이 불가능한 좌석번호 입니다");
//			} else if(array1[i] != ticket[ticket.length-1]){
//				System.out.println("예약했습니다");
//			}
//		}
//		
//		for (int i = 0; i < ticket.length; i++) {
//			boolean a = false;
//			for (int j = 0; j < i; j++) {
//				if (ticket[i] == ticket[j]) {
//					a = true;
//				}
//			}
//			if (a == false) {
//				array1[i] = ticket[i];
//			} System.out.println(array1[i]);
//		}
//		
//		System.out.println("예약할 자리는?");
//		pos = scan.nextInt();
//		
//		for (int i = 0; i < ticket.length; i++) {
//			System.out.println("다시 한번 자리번호를 입력해 주세요");
//			ticket[i] = scan.nextInt();
//			System.out.println(ticket[i]);
//		}
//		
//		
//		for(int i =0; i< ticket.length; i++) {
//			if( array1[i] == ticket[ticket.length-1]) {
//				System.out.println("이미 예약되어 있습니다");
//			} else if ( ticket[ticket.length-1]>10 || ticket[ticket.length-1]<1) {
//				System.out.println("예약이 불가능한 좌석번호 입니다");
//			} else if(array1[i] != ticket[ticket.length-1]){
//				System.out.println("예약했습니다");
//			}
//		}
//		
//		for (int i = 0; i < ticket.length; i++) {
//			boolean a = false;
//			for (int j = 0; j < i; j++) {
//				if (ticket[i] == ticket[j]) {
//					a = true;
//				}
//			}
//			if (a == false) {
//				array1[i] = ticket[i];
//			} System.out.println(array1[i]);
//		}
		
		Scanner scan = new Scanner(System.in);			// 9번문제
		System.out.println("예약할 자리는?");
		int pos = scan.nextInt(); 
		int[] ticket = new int[pos];
		int[] array1 = new int[10];
		do{
			System.out.println("예약할 자리는?");
		}

	}
}
