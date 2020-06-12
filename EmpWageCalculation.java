class EmpWageCalculation {
	int dailySalary[] = new int[20];
	int monthlySalary[] = new int[20];
	public static void calcEmpWageForCompany(String company, int empRatePerHr, int numWorkingDays, int totalWorkingHrs) {
		//variables
		int totalEmpHrs=0, totalEmpWage=0, totalWorkingDays=0, empWage=0;
		//Calculation
		while(totalWorkingDays<=numWorkingDays && totalEmpHrs<=totalWorkingHrs) {
			int empHrs = 0;
			totalWorkingDays++;
			int empCheck=(int)(Math.random() * 10) % 3;
			switch (empCheck) {
				case 2:
					empHrs=8;
					break;
				case 1:
					empHrs=4;
					break;
				default:
					empHrs=0;
					break;
			}
			if(totalEmpHrs+empHrs <= totalWorkingHrs) {
				totalEmpHrs += empHrs;
				empWage = empHrs * empRatePerHr;
				totalEmpWage += empWage;
			}
			System.out.println("EmpWage: "+empWage);
		}
		System.out.println("Total Employee Wage for company: "+company+" Salary: "+ totalEmpWage);
	}
	public static void main(String arrgs[]) {
		calcEmpWageForCompany("Dmart",20,20,100);
		calcEmpWageForCompany("Relaiance",10,40,200);
	}
}
