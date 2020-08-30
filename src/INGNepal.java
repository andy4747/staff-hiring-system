import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class INGNepal {
    JFrame frame;
    FullTimeStaffHire fullTime;
    PartTimeStaffHire partTime;


    private ArrayList<StaffHire> list = new ArrayList<StaffHire>();



    public INGNepal() {
        configuration(1600,850,"Staff Hiring System");
        fullTimeParts();
        partTimeParts();
        terminator();

        frame.setVisible(true);
    }

    //Some Basic properties of GUI
    public void configuration(int xAxis,int yAxis,String appName) {
        frame = new JFrame(appName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xAxis,yAxis);
        frame.setLayout(null);

    }

    //Method containing GUI for FULL TIME STAFF
    public void fullTimeParts() {


        //Description
        JLabel description = new JLabel("Hire Full Time Staff");
        description.setBounds(350,30,150,20);
        frame.add(description);

        //(Label Staff => Name)
        JLabel fullStaffName = new JLabel("Staff Name: ");
        fullStaffName.setBounds(20,80,100,40);
        frame.add(fullStaffName);

        //(Text Field => Staff Name)
        JTextField fullStaffField = new JTextField();
        fullStaffField.setBounds(140,80,200,40);
        frame.add(fullStaffField);

        //(Label => designation)
        JLabel fullDesigLabel = new JLabel("Designation: ");
        fullDesigLabel.setBounds(20,150,120,40);
        frame.add(fullDesigLabel);


        //(Text Field => designation)
        JTextField fullDesigField = new JTextField();
        fullDesigField.setBounds(140,150,200,40);
        frame.add(fullDesigField);

        //(Label => Working Hour)
        JLabel fullWorkingLabel = new JLabel("Working Hours: ");
        fullWorkingLabel.setBounds(20,220,120,40);
        frame.add(fullWorkingLabel);

        //(Text Field => Working Hour)
        JTextField fullWorkingField = new JTextField();
        fullWorkingField.setBounds(140,220,200,40);
        frame.add(fullWorkingField);

        //(Label => vacancy number)
        JLabel fullvacancyLabel = new JLabel("Vacancy No: ");
        fullvacancyLabel.setBounds(400,80,120,40);
        frame.add(fullvacancyLabel);

        //(Text Field => vacancy number)
        JTextField fullvacancyField = new JTextField();
        fullvacancyField.setBounds(520,80,200,40);
        frame.add(fullvacancyField);

        //(Label => Job Type)
        JLabel fullJobLabel = new JLabel("Job Type: ");
        fullJobLabel.setBounds(400,150,120,40);
        frame.add(fullJobLabel);

        //(Text Field => Job Type)
        JTextField fullJobField = new JTextField();
        fullJobField.setBounds(520,150,200,40);
        frame.add(fullJobField);

        //(Label => Joined)
        JLabel fullQualificationLabel = new JLabel("Qualification: ");
        fullQualificationLabel.setBounds(400,220,120,40);
        frame.add(fullQualificationLabel);

        //(Combo Box => Qualification)
        JTextField fullQualificationField = new JTextField();
        fullQualificationField.setBounds(520,220,200,40);
        frame.add(fullQualificationField);

        //(Label => Appointed By)
        JLabel fullAppointedLabel = new JLabel("Appointed By: ");
        fullAppointedLabel.setBounds(400,290,120,40);
        frame.add(fullAppointedLabel);

        //(Text Field => Appointed By)
        JTextField fullAppointedField = new JTextField();
        fullAppointedField.setBounds(520,290,200,40);
        frame.add(fullAppointedField);


        //(Label => Salary)
        JLabel fullSalaryLabel = new JLabel("Salary: ");
        fullSalaryLabel.setBounds(20,290,120,40);
        frame.add(fullSalaryLabel);

        //(Text Field => Salary)
        JTextField fullSalaryField = new JTextField();
        fullSalaryField.setBounds(140,290,200,40);
        frame.add(fullSalaryField);

        //(Label => joining date)
        JLabel fullJoiningLabel = new JLabel("Joining Date: ");
        fullJoiningLabel.setBounds(20,360,120,40);
        frame.add(fullJoiningLabel);

        //(Text Field => joining date)
        JTextField fullJoiningField = new JTextField();
        fullJoiningField.setBounds(140,360,200,40);
        frame.add(fullJoiningField);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(280,420,120,30);
        frame.add(clearBtn);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg) {
                fullQualificationField.setText(null);
                fullAppointedField.setText(null);
                fullWorkingField.setText(null);
                fullvacancyField.setText(null);
                fullJoiningField.setText(null);
                fullSalaryField.setText(null);
                fullDesigField.setText(null);
                fullStaffField.setText(null);
                fullJobField.setText(null);

            }
        });

        //add button
        JButton fullAddBtn = new JButton("Add");
        fullAddBtn.setBounds(140,420,120,30);
        frame.add(fullAddBtn);
        fullAddBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                int vacancy = 0,workingHour = 0,income = 0;
                String vacNo = fullvacancyField.getText();
                String staffName = fullStaffField.getText();
                String designation = fullDesigField.getText();
                String jobType = fullJobField.getText();
                String salary = fullSalaryField.getText();
                String joinedDate = fullJoiningField.getText();
                String workHours = fullWorkingField.getText();
                String appointedBy = fullAppointedField.getText();
                String qualification = fullQualificationField.getText();

                if(vacNo.trim().equals("")||staffName.trim().equals("")||designation.trim().equals("")||jobType.trim().equals("")||salary.trim().equals("")||joinedDate.trim().equals("")||workHours.trim().equals("")||appointedBy.trim().equals("")||qualification.trim().equals("")) {
                    JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                }else {
                    try {
                        vacancy = Integer.parseInt(vacNo);
                        workingHour = Integer.parseInt(workHours);
                        income = Integer.parseInt(salary);
                    }catch(NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                        return;
                    }
                    for(StaffHire staff : list) {
                        if(staff instanceof FullTimeStaffHire) {
                            FullTimeStaffHire full = (FullTimeStaffHire) staff;
                            if(full.getVacancyNumber() == vacancy) {
                                JOptionPane.showMessageDialog(frame,"staff already hired");
                            }
                        }
                    }
                }
                fullTime = new FullTimeStaffHire(vacancy, designation, jobType, income, workingHour);
                list.add(fullTime);
            }
        });


        //appoint button
        JButton fullAppointButton = new JButton("Appoint");
        fullAppointButton.setBounds(420,420,120,30);
        frame.add(fullAppointButton);
        fullAppointButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                int vacancy = 0;
                String vacNo = fullvacancyField.getText();
                String staffName = fullStaffField.getText();
                String designation = fullDesigField.getText();
                String jobType = fullJobField.getText();
                String salary = fullSalaryField.getText();
                String joinedDate = fullJoiningField.getText();
                String workHours = fullWorkingField.getText();
                String appointedBy = fullAppointedField.getText();
                String qualification = fullQualificationField.getText();

                //vacancyNumber
                //staffName
                //joiningDate
                //qualification
                //appointedBy

                if(vacNo.trim().equals("")||staffName.trim().equals("")||designation.trim().equals("")||jobType.trim().equals("")||salary.trim().equals("")||joinedDate.trim().equals("")||workHours.trim().equals("")||appointedBy.trim().equals("")||qualification.trim().equals("")) {
                    JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                }else {
                    try {
                        vacancy = Integer.parseInt(vacNo);
                    }catch(NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                        return;
                    }
                }
                for(int i=0;i<list.size();i++) {
                    StaffHire sh = list.get(i);
                    if(sh instanceof FullTimeStaffHire) {
                        FullTimeStaffHire full = (FullTimeStaffHire)sh;
                        if(full.getVacancyNumber()==vacancy) {
                            full.hireFullTimeStaff(staffName, joinedDate, qualification, appointedBy);
                            JOptionPane.showMessageDialog(frame,"Staff hired successfully");
                            break;
                        }else {
                            JOptionPane.showMessageDialog(frame,"vacancy number not found");
                        }
                    }
                }
            }
        });
    }

    public void partTimeParts() {

        //Description
        JLabel description = new JLabel("Hire Part Time Staff");
        description.setBounds(1150,30,150,20);
        frame.add(description);

        //(Label Staff => Name)
        JLabel partStaffName = new JLabel("Staff Name: ");
        partStaffName.setBounds(800,80,100,40);
        frame.add(partStaffName);

        //(Text Field => Staff Name)
        JTextField partStaffField = new JTextField();
        partStaffField.setBounds(940,80,200,40);
        frame.add(partStaffField);

        //(Label => vacancy number)
        JLabel partVacancyLabel = new JLabel("Vacancy No: ");
        partVacancyLabel.setBounds(800,150,120,40);
        frame.add(partVacancyLabel);


        //(Text Field => vacancy number)
        JTextField partVacancyField = new JTextField();
        partVacancyField.setBounds(940,150,200,40);
        frame.add(partVacancyField);

        //(Label => designation)
        JLabel partDesigLabel = new JLabel("Designation: ");
        partDesigLabel.setBounds(800,220,120,40);
        frame.add(partDesigLabel);

        //(Text Field => designation)
        JTextField partDesigField = new JTextField();
        partDesigField.setBounds(940,220,200,40);
        frame.add(partDesigField);

        //(Label => job type)
        JLabel partJobLabel = new JLabel("Job Type: ");
        partJobLabel.setBounds(1200,80,120,40);
        frame.add(partJobLabel);

        //(Text Field => job type)
        JTextField partJobField = new JTextField();
        partJobField.setBounds(1340,80,200,40);
        frame.add(partJobField);

        //(Label => Appointed By)
        JLabel partAppointedLabel = new JLabel("Appointed By: ");
        partAppointedLabel.setBounds(1200,150,120,40);
        frame.add(partAppointedLabel);

        //(Text Field => Appointed By)
        JTextField partAppointedField = new JTextField();
        partAppointedField.setBounds(1340,150,200,40);
        frame.add(partAppointedField);

        //(Label => Joined)
        JLabel partJoinLabel = new JLabel("Joining Date: ");
        partJoinLabel.setBounds(1200,220,120,40);
        frame.add(partJoinLabel);

        //(Combo Box => Joining date)
        JTextField partJoinField = new JTextField();
        partJoinField.setBounds(1340,220,200,40);
        frame.add(partJoinField);

        //(Label => working hours)
        JLabel partWorkLabel = new JLabel("Working Hours: ");
        partWorkLabel.setBounds(1200,290,120,40);
        frame.add(partWorkLabel);

        //(Combo Box => working hours)
        JTextField partWorkField = new JTextField();
        partWorkField.setBounds(1340,290,200,40);
        frame.add(partWorkField);

        //(Label => qualification)
        JLabel partQualLabel = new JLabel("Qualification: ");
        partQualLabel.setBounds(1200,360,120,40);
        frame.add(partQualLabel);

        //(Combo Box => qualification)
        JTextField partQualField = new JTextField();
        partQualField.setBounds(1340,360,200,40);
        frame.add(partQualField);

        //(Label => Shifts)
        JLabel partShiftLabel = new JLabel("Shifts: ");
        partShiftLabel.setBounds(800,290,120,40);
        frame.add(partShiftLabel);

        //(Text Field => Shifts)
        JTextField partShiftField = new JTextField();
        partShiftField.setBounds(940,290,200,40);
        frame.add(partShiftField);

        //(Label => wages per hour)
        JLabel partWagesLabel = new JLabel("Wages Per Hr: ");
        partWagesLabel.setBounds(800,360,120,40);
        frame.add(partWagesLabel);

        //(Text Field => wages per hour)
        JTextField partWagesField = new JTextField();
        partWagesField.setBounds(940,360,200,40);
        frame.add(partWagesField);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(1080,420,120,30);
        frame.add(clearBtn);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                partVacancyField.setText(null);
                partDesigField.setText(null);
                partJobField.setText(null);
                partAppointedField.setText(null);
                partShiftField.setText(null);
                partWagesField.setText(null);
                partStaffField.setText(null);
                partJoinField.setText(null);
                partWorkField.setText(null);
                partQualField.setText(null);



            }
        });

        //add button
        JButton partAddBtn = new JButton("Add");
        partAddBtn.setBounds(940,420,120,30);
        frame.add(partAddBtn);
        partAddBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int vacancy,workingHours,wageshour;
                String vacNo =partVacancyField.getText();
                String designation =partDesigField.getText();
                String job =partJobField.getText();
                String appointed =partAppointedField.getText();
                String shift =partShiftField.getText();
                String wages =partWagesField.getText();
                String name =partStaffField.getText();
                String date =partJoinField.getText();
                String work =partWorkField.getText();
                String qualification =partQualField.getText();

                if(vacNo.trim().equals("") || designation.trim().equals("") || job.trim().equals("") || appointed.trim().equals("") || shift.trim().equals("") || wages.trim().equals("") || name.trim().equals("") || date.trim().equals("") || work.trim().equals("") || qualification.trim().equals("")) {
                    JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                }else {
                    try {
                        vacancy = Integer.parseInt(vacNo);
                        workingHours = Integer.parseInt(work);
                        wageshour = Integer.parseInt(wages);
                    }catch(NumberFormatException arg) {
                        JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                        return;
                    }
                    for(StaffHire staff : list) {
                        if(staff instanceof PartTimeStaffHire) {
                            PartTimeStaffHire part = (PartTimeStaffHire) staff;
                            if(part.getVacancyNumber() == vacancy) {
                                JOptionPane.showMessageDialog(frame,"staff already hired");
                            }
                        }
                    }
                    partTime = new PartTimeStaffHire(vacancy, designation, job, workingHours, wageshour, shift);
                    list.add(partTime);
                }
            }
        });

        JButton appointBtn = new JButton("Appoint");
        appointBtn.setBounds(1220,420,120,30);
        frame.add(appointBtn);
        appointBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int vacancy=0;
                String vacNo =partVacancyField.getText();
                String designation =partDesigField.getText();
                String job =partJobField.getText();
                String appointed =partAppointedField.getText();
                String shift =partShiftField.getText();
                String wages =partWagesField.getText();
                String name =partStaffField.getText();
                String date =partJoinField.getText();
                String work =partWorkField.getText();
                String qualification =partQualField.getText();

                if(vacNo.trim().equals("") || designation.trim().equals("") || job.trim().equals("") || appointed.trim().equals("") || shift.trim().equals("") || wages.trim().equals("") || name.trim().equals("") || date.trim().equals("") || work.trim().equals("") || qualification.trim().equals("")) {
                    JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                }else {
                    try {
                        vacancy = Integer.parseInt(vacNo);
                    }catch(NumberFormatException arg) {
                        JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                        return;
                    }
                }
                for(int i=0;i<list.size();i++) {
                    StaffHire sh = list.get(i);
                    if(sh instanceof PartTimeStaffHire) {
                        PartTimeStaffHire part = (PartTimeStaffHire)sh;
                        if(part.getVacancyNumber()==vacancy) {
                            part.hirePartTimeStaff(name, date, qualification, appointed);
                            JOptionPane.showMessageDialog(frame,"Staff hired successfully");
                            break;
                        }else {
                            JOptionPane.showMessageDialog(frame,"vacancy number not found");
                        }
                    }
                }

            }
        });
    }

    public void terminator() {
        //Description
        JLabel desc = new JLabel("Terminate a Staff: ");
        desc.setBounds(700,500,150,20);
        frame.add(desc);

        //vacancy number
        JLabel vacNo = new JLabel("Vacancy No: ");
        vacNo.setBounds(600,560,120,20);
        frame.add(vacNo);

        JTextField vacField = new JTextField();
        vacField.setBounds(700,550,200,40);
        frame.add(vacField);


        //button display
        JButton display = new JButton("Display");
        display.setBounds(820,670,120,30);
        frame.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg) {
                for(StaffHire staff : list) {
                    if(staff instanceof FullTimeStaffHire) {
                        FullTimeStaffHire full = (FullTimeStaffHire)staff;
                        staff.display();
                    }else {
                        PartTimeStaffHire part = (PartTimeStaffHire)staff;
                        staff.display();
                    }
                }
            }
        });

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(580,670,120,30);
        frame.add(clearBtn);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                vacField.setText(null);

            }
        });

        //button terminate
        JButton terminate = new JButton("Terminate");
        terminate.setBounds(700,620,120,30);
        frame.add(terminate);
        terminate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String vacNo = vacField.getText();
                int vacancy = 0;
                if(vacNo.trim().equals("")) {
                    JOptionPane.showMessageDialog(frame,"Please fill the form correctly");
                }else {
                    try {
                        vacancy = Integer.parseInt(vacNo);
                    }catch(NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(frame,"Please enter correct vacancy number");
                        return;
                    }
                }
                boolean found = false;
                for(StaffHire staff : list) {
                    if(staff instanceof PartTimeStaffHire) {
                        PartTimeStaffHire part = (PartTimeStaffHire) staff;
                        if(staff.getVacancyNumber() == vacancy) {
                            part.terminateStaff();
                            list.remove(staff);
                            JOptionPane.showMessageDialog(frame,"staff terminated succesfully");
                            found = true;
                        }
                    }
                }
                if(!found) {
                    JOptionPane.showMessageDialog(frame,"vacancy number is invalid");
                }

            }
        });

    }

    public static void main(String[] args) {
        new INGNepal();
    }
}
