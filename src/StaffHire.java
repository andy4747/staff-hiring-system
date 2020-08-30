public class StaffHire
{
    //attributes
    private int vacancyNumber;
    private String designation;
    private String jobType;

    //Constructor
    public StaffHire(int vacancyNumber, String designation, String jobType){
        this.vacancyNumber = vacancyNumber; // this keyword refers to the current instance variable
        this.designation = designation;
        this.jobType = jobType;
    }

    //Setter Methods
    public void setVacancyNumber(int vacancyNumber){
        this.vacancyNumber = vacancyNumber;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }

    public void setJobType(String jobType){
        this.jobType = jobType;
    }

    //Getter Methods
    public int getVacancyNumber(){return vacancyNumber;}

    public String getDesignation(){return designation;}

    public String getJobType(){return jobType;}


    //A method that displays vacancy number, designation and job type.
    public void display(){
        System.out.println("Vacancy Number: "+getVacancyNumber());
        System.out.println("Designation: "+getDesignation());
        System.out.println("Job Type: "+getJobType());
    }
}