package chap05;

public class Array문제Exam {

	public static void main(String[] args) {
		
		// 연습문제 5. 223p.
		
		int[][] array = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88},
		};
		
////		1.모두 출력
//		int[] array1 = array[0]; // {95, 86}
////		array1[0]
//		System.out.println(array[0][0]);
//		System.out.println(array[0][1]);
//	
//		System.out.println(array[1][0]);
//		System.out.println(array[1][1]);
//		System.out.println(array[1][2]);
//		
////		array[0].length 만큼
//		for(int i=0; i<array[0].length; i++) {
//			System.out.println(array[0][i]);
//		}
//		
//		for(int i=0; i<array[0].length; i++) {
//			System.out.println(array[0][i]);
//		}
//		
//		for(int j=0; j<array.length; j++) {
//			for(int i=0; i<array[j].length; i++) {
//				System.out.println(array[j][i]);
//			}
//		}
		
//		2. 합계 출력
//		int sum =0;
//		for(int j=0; j<array.length; j++) {
//			for(int i=0; i<array[j].length; i++) {
//				sum += array[j][i];
//			}
//		}
//		System.out.println("총합 : "+sum);

//		3. 평균 출력(합계를 개수로 나누기)
		
//		int count=0;
//		for(int i=0; i<array.length;i++) {
//			count += array[i].length;
//		}
//		System.out.println(count);
//		
//		
		int sum= 0;
		double avg =0.0;
		int count =0;
		
		for(int i= 0; i< array.length; i++) {
			for(int j=0; j< array[i].length;j++) {
				System.out.println(array[i][j]);
			}
		}
		
		for(int i= 0; i< array.length; i++) {
			for(int j=0; j< array[i].length;j++) {
				sum += array[i][j];
				count++;
			}
		}
		System.out.println("총합 :"+sum);
		
		for(int i= 0; i< array.length; i++) {
			for(int j=0; j< array[i].length;j++) {
				avg = sum/(count);
			}
		}
		System.out.println(avg);
	}

}
