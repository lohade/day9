public class EmployeeWage {
    public static  final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;



    public static int EmployeeWage(String company,int EMP_RATE_PER_HOURS,int NUM_OF_WORKING_DAYS,int MAX_HRS_IN_MONTH){
        int empHrs;
        int totalWorkingDays=0;
        int totalEmpHrs=0;

        while(totalEmpHrs<=MAX_HRS_IN_MONTH && totalWorkingDays< NUM_OF_WORKING_DAYS)
        {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;

            }

            totalEmpHrs+=empHrs;
            System.out.println("day#: " +totalWorkingDays + "emp hr:" +empHrs);
        }
        int totalEmpWage=totalEmpHrs * EMP_RATE_PER_HOURS;
        System.out.println("company:" +company+" is giving total wage:" +totalEmpWage);
        return totalEmpWage;

    }



    public static void main(String[] args) {
        // write your code here
        EmployeeWage("Atos",20,20,100);
        EmployeeWage("techM",15,15,25);

    }
}