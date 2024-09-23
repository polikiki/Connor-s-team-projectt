package sec02.exam01;

public class DriverExam {

	public static void main(String[] args) {
		
		Avante avante = new Avante();
		
		Driver driver = new Driver();
		Car car = (Car)avante; // 없어도 됨 이해를 위해 작성
		driver.run(avante);
		
		Spark spark = new Spark();
		driver.run(spark);

	}

}
