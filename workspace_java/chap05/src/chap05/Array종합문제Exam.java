package chap05;

public class Array종합문제Exam {

	public static void main(String[] args) {
		
		int[] array = { 1, 5, 2, 4 }; // 1번 문제
//		for(int i=array.length-1; i >= 0;i--)
//		System.out.println(array[i]);

		
		int[] array2 = new int[array.length+1];
		
		for(int i=0; i<array2.length; i++) {
			array2[i] = array[i];

		}
		
		array2[0]= 0;
		for(int i=0; i<array2.length; i++) {
			
			System.out.println(array2[i]);
		}

	}

}
