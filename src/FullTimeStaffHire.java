public class FullTimeStaffHire extends StaffHire
{
    //attributes
    private int salary;
    private int workingHours;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    //Constructor
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, int salary, int workingHours){
        super(vacancyNumber, designation, jobType); //super keyword refers to parent class instance variable.
        this.salary = salary;
        this.workingHours = workingHours;
        this.staffName = "";
        this.joiningDate = "";
        this.qualification = "";
        this.appointedBy = "";
        this.joined = false;
    }

    //setter methods
    public void setSalary(int salary){
        if(joined == false){
            this.salary = salary;
        }else{
            System.out.println("Changes to salary not possible becauese staff has already joined");
        }
    }
    public void setWorkingHours(int workingHours){ // also accepts new workingHour as parameter and assigns new value to workingHour attribute.
        this.workingHours = workingHours;
    }
    public void setStaffName(String staffName){
        this.staffName = staffName;
    }
    public void setJoiningDate(String joiningDate){
        this.joiningDate = joiningDate;
    }
    public void setQualification(String qualification){
        this.qualification = qualification;
    }
    public void setAppointedBy(String appointedBy){
        this.appointedBy = appointedBy;
    }
    public void setJoined(boolean joined){
        this.joined = joined;
    }

    //getter methods
    public int getSalary(){return salary;}

    public int getWorkingHours(){return workingHours;}

    public String getStaffName(){return staffName;}

    public String getJoiningDate(){return joiningDate;}

    public String getQualification(){return qualification;}

    public String getAppointedBy(){return appointedBy;}

    public boolean getJoined(){return joined;}

    //hires staffs if staff has not joined.
    public void hireFullTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy){
        if(joined==true){
            System.out.println(staffName+" has already joined on "+joiningDate);
        }
        else{
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            this.joined = true;
        }
    }

    //method that displays details of the staff if the staff has already joined
    public void display(){
        super.display(); //calling  display method from parent class
        if(joined==true){
            System.out.println("Staff Name: "+getStaffName());
            System.out.println("Salary: "+getSalary());
            System.out.println("Total Woring Hours: "+getWorkingHours());
            System.out.println("Joined Date: "+getJoiningDate());
            System.out.println("Qualification: "+getQualification());
            System.out.println("Appointed By: "+getAppointedBy());
        }
    }
}