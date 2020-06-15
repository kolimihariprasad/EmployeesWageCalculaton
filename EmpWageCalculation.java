import java.util.*;
interface EmpWage {
	void addCompanyEmpWage (String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth);
	void computeEmpWage();
	int getTotalWage(String company);
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

	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private Map<String,CompanyEmpWage> companytoEmpWageMap;

	public EmpWageCalculation() {
	companyEmpWageList = new LinkedList<>();
	companytoEmpWageMap = new HashMap<>();
	}
	public void addCompanyEmpWage (String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companytoEmpWageMap.put(company, companyEmpWage);
	}
	public void computeEmpWage() {
		for(int i=0; i <companyEmpWageList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}
	public int getTotalWage(String company) {
		return companytoEmpWageMap.get(company).totalEmpWage;
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
		Scanner input = new Scanner(System.in);
		EmpWageCalculation empWage = new EmpWageCalculation();
		int choice;
		while(true){
			System.out.print("press 1 to calculate wage for another company 0 to stop ");
			choice =Integer.parseInt(input.nextLine());
			if(choice == 0)
				break;
			System.out.print("Enter your Company name: ");
			String cmpName=input.nextLine();
			System.out.print("Enter your empRatePerHour name: ");
			int empRateHour = Integer.parseInt(input.nextLine());
			System.out.print("Enter your numOfWrkingDays name: ");
			int numOfWrkingDays = Integer.parseInt(input.nextLine());
			System.out.print("Enter your maxHoursPerMonth name: ");
			int maxHoursPerMonth = Integer.parseInt(input.nextLine());
			empWage.addCompanyEmpWage(  cmpName,  empRateHour,  numOfWrkingDays,  maxHoursPerMonth );
			empWage.computeEmpWage();
		}
		System.out.print("Enter your Company name to get TotoalWage: ");
		String Name=input.nextLine();
		System.out.println("Total Wage for company: "+empWage.getTotalWage(Name));
	}
}
