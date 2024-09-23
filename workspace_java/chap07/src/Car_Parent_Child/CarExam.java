package Car_Parent_Child;

public class CarExam {

	public static void main(String[] args) {
		승용차 a1 = new 승용차();
		
		a1.filling(20);
		a1.drive(100);
		a1.get_Exhaust_gas();
		
		버스 a2 = new 버스();
		
		a2.filling(20);
		a2.drive(100);
		a2.get_Exhaust_gas();
		
		전차 a3 = new 전차();
		
		a3.filling(20);
		a3.drive(100);
		a3.get_Exhaust_gas();
		
		
	}

}
