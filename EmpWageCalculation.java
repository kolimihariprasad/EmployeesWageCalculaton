class Employe {
	//Constants
	final int IS_FULL_TIME=2;
	final int IS_PART_TIME=1;
	final int EMP_RATE_PER_HR=20;
	//Variables
	int empHrs=0;
	int totalSalary=0;
	int EmployeeCheck() {
		int empCheck=(int)(Math.random() * 10) % 3;
		 System.out.println(empCheck);
		if (empCheck == IS_FULL_TIME)
			return 8;
		else if(empCheck == IS_PART_TIME)
			return 4;
		else
			return 0;
	}
	void WageCalculation() {
		empHrs=EmployeeCheck();
		totalSalary=empHrs*EMP_RATE_PER_HR;
		System.out.println(totalSalary);

	}
	Employe() {
		WageCalculation();
	}
}
class EmpWageCalculation {
	public static void main(String arrgs[]) {
		Employe empOne = new Employe();
	}
}
