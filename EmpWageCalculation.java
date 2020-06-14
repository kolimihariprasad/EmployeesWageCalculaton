interface EmpWage {
	void addCompanyEmpWage (String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth);
	void computeEmpWage();
	}
class CompanyEmpWage {
	String company;
	int empRatePerHour;
	int numOfWorkingDays;
	int maxHoursPerMonth;
	public int totalEmpWage;
	public CompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth) {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
	}
	public void setTotalEmpWage(int totalEmpWage) {
	this.totalEmpWage = totalEmpWage;
	}
	public String toString() {
		return "Total Emp Wage for Company:" +company+" is: "+totalEmpWage;
	}
}
public class EmpWageCalculation implements EmpWage{
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;

	private int numOfCompanies =0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmpWageCalculation() {
	companyEmpWageArray = new CompanyEmpWage[5];
	}
	public void addCompanyEmpWage (String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth) {
		companyEmpWageArray[numOfCompanies] = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		numOfCompanies++;
	}
	public void computeEmpWage() {
		for(int i=0; i < numOfCompanies; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	int computeWage(CompanyEmpWage companyEmpWage) {
		//variables
		int totalEmpHrs=0, totalWorkingDays=0, totalEmpWage=0;
		//Calculation
		while(totalEmpHrs<=companyEmpWage.maxHoursPerMonth && totalWorkingDays<=companyEmpWage.numOfWorkingDays) {
			int empHrs = 0;
			totalWorkingDays++;
			int empCheck=(int)(Math.random() * 10) % 3;
			switch (empCheck) {
				case IS_FULL_TIME:
					empHrs=8;
					break;
				case IS_PART_TIME:
					empHrs=4;
					break;
				default:
					empHrs=0;
					break;
			}
			if(totalEmpHrs+empHrs <= companyEmpWage.maxHoursPerMonth) {
				totalEmpHrs += empHrs;
				}
				System.out.println("Day "+totalWorkingDays +" Emp Hrs: "+empHrs);
		}
			int wage = totalEmpHrs*companyEmpWage.empRatePerHour;
		return wage;
	}
	public static void main(String args[]){
		EmpWageCalculation empWage = new EmpWageCalculation();
		empWage.addCompanyEmpWage("Dmart",20,20,100);
		empWage.addCompanyEmpWage("Tata",50,20,80);
		empWage.computeEmpWage();
	}
}
