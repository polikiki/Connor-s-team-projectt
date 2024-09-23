package sec04.exam12;

public class BankExam {

	public static void main(String[] args) {
		
		Bank bank = new Bank("신한은행");
		bank.view();
		bank.income(240000000);
		bank.view();
		bank.outcome(22000000);
		bank.view();
		
		bank.income(-10000);
		bank.view();
		
//		bank.insert();
//		bank.withDraw();
//		bank.balance();
		
		Bank bank2 = new Bank("신협");
		bank2.income(20000);
		bank2.outcome(5000);
		bank2.view();
		
		bank.view();
		
	}

}
