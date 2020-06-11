class Employe {
	final int IS_FULL_TIME=1;
	void EmployeeCheck() {
		int empCheck=(int)(Math.random() * 10) % 2;
		if (empCheck == IS_FULL_TIME)
			System.out.println("Present");
		else
			System.out.println("Absent");
	}
}
class EmpWageCalculation {
	public static void main(String arrgs[]) {
		Employe empOne = new Employe();
		empOne.EmployeeCheck();
	}
}
