public class PartTimeStaffHire extends StaffHire
{
    //attributes
    private int workingHours;
    private int wagesPerHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private String shifts;
    private boolean joined;
    private boolean terminated;

    //constructor
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, int woringHours, int wagesPerHour, String shifts){
        super(vacancyNumber,designation,jobType);
        this.workingHours = woringHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.staffName = "";
        this.joiningDate = "";
        this.qualification = "";
        this.appointedBy = "";
        this.joined = false;
        this.terminated = false;
    }

    //setter methods
    public void setWorkingHours(int workingHours){
        this.workingHours = workingHours;
    }

    public void setWagesPerHour(int wagesPerHour){
        this.wagesPerHour = wagesPerHour;
    }

    public void setShifts(String shifts){
        if(joined==false){
            this.shifts = shifts;
        }
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

    public void setTerminated(boolean terminated){
        this.terminated = terminated;
    }

    //getter methods
    public int getWorkingHours() {return workingHours;}

    public int getWagesPerHour() {return wagesPerHour;}

    public String getStaffName() {return staffName;}

    public String getJoiningDate() {return joiningDate;}

    public String getQualification() {return qualification;}

    public String getAppointedBy() {return appointedBy;}

    public boolean getJoined() {return joined;}

    public boolean getTerminated() {return terminated;}

    //method to hire part time staff if the staff has not joined yet.
    public void hirePartTimeStaff(String staffName, String joinedDate, String qualification, String appointedBy){
        if(joined==true){
            System.out.println(staffName+" has already joined on "+joinedDate);
        }else{
            this.staffName = staffName;
            this.joiningDate = joinedDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            this.joined = true;
            this.terminated = false;
        }
    }

    //method that terminates a staff if not already terminated and sets attribute values empty.
    public void terminateStaff(){
        if(terminated==true){
            System.out.println(staffName+" is already terminated");
        }else{
            this.staffName = "";
            this.joiningDate = "";
            this.qualification = "";
            this.appointedBy = "";
            this.joined = false;
            this.terminated = true;
        }
    }

    //method that displays the details of staff if staff has already joined
    public void diaplay(){
        super.display(); //calling  display method from parent class
        if(joined==true){
            System.out.println("Staff Name: "+getStaffName());
            System.out.println("Wages Per Hour: "+getWagesPerHour());
            System.out.println("Total Woring Hours: "+getWorkingHours());
            System.out.println("Joined Date: "+getJoiningDate());
            System.out.println("Qualification: "+getQualification());
            System.out.println("Appointed By: "+getAppointedBy());
            System.out.println("Income Per Day: "+this.wagesPerHour*this.workingHours);
        }
    }
}