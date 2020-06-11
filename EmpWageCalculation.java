class Employe {
	//Constants
	final int IS_FULL_TIME=2;
	final int IS_PART_TIME=1;
	final int EMP_RATE_PER_HR=20;
	final int TOTAL_WORKING_DAYS=20;
	final int TOTAL_WORKING_HOURS=100;
	//Variables
	int empHrs=0;
	int totalSalary=0;
	int numWorkingDays=1;
	int totalHrs=0;
	int dailySalary[] = new int[20];
	int monthlySalary[] = new int[20];
	int EmployeeCheck() {
			int empCheck=(int)(Math.random() * 10) % 3;
			switch (empCheck) {
				case 2:
					return 8;
				case 1:
					return 4;
				default:
					return 0;
			}
	}
	void WageCalculation() {
		int day=0;
		while(numWorkingDays<=TOTAL_WORKING_DAYS && totalHrs<=TOTAL_WORKING_HOURS) {
			empHrs=EmployeeCheck();
			if(totalHrs+empHrs<=100) {
				totalHrs+=empHrs;
			totalSalary=totalHrs*EMP_RATE_PER_HR;
			numWorkingDays++;
			dailySalary[day]=empHrs*EMP_RATE_PER_HR;
			monthlySalary[day]=totalSalary;
			day++;
			}
		}
	}
	Employe() {
		WageCalculation();
		int day=1;
		System.out.println("Day\tdailySalary\tmonthlySalary");
		for(int i=0;i<=20;i++){
		System.out.println("Day "+day+"\t\t"+dailySalary[i]+"\t\t"+monthlySalary[i]);
			day++;
		}
	}
}
class EmpWageCalculation {
	public static void main(String arrgs[]) {
		Employe empOne = new Employe();

	}
}
