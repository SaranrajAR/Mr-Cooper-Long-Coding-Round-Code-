
import java.util.*;
public class Hospital {
    static int pIdInc=1;

    static List<Patient> patients = new ArrayList<>();

    public void registerPatient(String name,int age,String phone){
        Patient p = new Patient(pIdInc++,name,age,phone);
        patients.add(p);
        p.getPatientDetails();
    }


    static Doctor d1 = new Doctor(1,"Dr. Harish","Bone");
    static Doctor d2 = new Doctor(2,"Dr. Deva","Skin");
    static Doctor d3 = new Doctor(3,"Dr. Sumanth","General");

    static List<List<Patient>> assignedSlots=new ArrayList<>();
    
    public static void getSlotDetails(){
        for(int i=0;i<20;i++){
            System.out.println("Slot:"+(i+1));
            if(assignedSlots.get(i).get(0)==null) System.out.println("Bone: This Slot is Not Booked");
            else System.out.println("Bone: This Slot is Booked");
            if(assignedSlots.get(i).get(1)==null) System.out.println("Skin: This Slot is Not Booked");
            else System.out.println("Skin: This Slot is Booked");
            if(assignedSlots.get(i).get(2)==null) System.out.println("General: This Slot is Not Booked");
            else System.out.println("General: This Slot is Booked");

        }
    }

    // public static void bookSlot()
    public static void main(String[] args) {
    for(int i=0;i<20;i++){
        assignedSlots.add(new ArrayList<>());
        for(int j=0;j<3;j++) assignedSlots.get(i).add(null);
    }
     Scanner sc = new Scanner(System.in);   
     System.out.println("Welcome to the Municipal Hospital Management System");
     while (true) {
        System.out.println("1. Register Patient");
        System.out.println("2. View All Doctor Details");
        System.out.println("3. View All Patient Details");
        System.out.println("4. BookAppointment for a Doctor");
        System.out.println("5: GetToday Slot Details");
        System.out.println("6 Cancel Apointment");
        System.out.println("7. Exit");
        int choice = sc.nextInt(); 
        switch (choice) {
            case 1:
                    System.out.print("Enter patient name: ");
                    String name = sc.next();
                    System.out.print("Enter patient age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter patient phone: ");
                    String phone = sc.next();
                    Hospital hospital = new Hospital();
                    hospital.registerPatient(name, age, phone);

                    System.out.println();
                break;
            case 2:
                d1.getDoctorDetails();
                d2.getDoctorDetails();
                d3.getDoctorDetails();
                break;
            case 3:
                for (Patient p : patients) {
                    p.getPatientDetails();
                }
                break;
            case 4:
                System.out.println("Enter your Id");
                int pId=sc.nextInt();
                System.out.println("Enter Prefreed Slot [1--20]");
                int slot=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Specalizt you have to consult");
                String sp=sc.nextLine();
                Patient temp=null;
                for(Patient p:patients){
                    if(p.pId==pId) temp=p;
                }   
                if(temp==null) {
                    System.out.println("---->>> No Patient Id exists with that");
                    break;
                }    
                else{
                    int idx=0;
                    if(sp.toLowerCase().equals("bone")) idx=0;
                    if(sp.toLowerCase().equals("skin")) idx=1;
                    if(sp.toLowerCase().equals("G")) idx=2;
                    if(assignedSlots.get(slot-1).get(idx)==null) {
                        assignedSlots.get(slot-1).set(idx,temp);
                        System.out.println("Succesfully Appointed for the Doctor:");
                        if(idx==0) d1.getDoctorDetails();
                        else if(idx==1) d2.getDoctorDetails();
                        else d3.getDoctorDetails();
                    }
                    else {
                        System.out.println("----> Error: No Doctor Available at Specified Slot");
                    }
                }
                break;

            case 5:
                getSlotDetails();
                break;   

            case 6:
                System.out.println("Enter Your Patient Id");
                int pid=sc.nextInt();
                boolean isPatientFound=false;
                for (Patient p : patients) {
                    if(p.pId==pid){
                        isPatientFound=true;
                        System.out.println("Patient Found");
                        break;
                    }
                }

                System.out.println("Enter Your Slot Booked i.e [1---20]");
                int sl=sc.nextInt();
                System.out.println("Enter Your sepcilist you have Booked i.e Bone or skin or general");
                sc.nextLine();
                String t=sc.nextLine().toLowerCase();
                int idx=0;
                if(t.equals("bone")) idx=0;
                else if(t.equals("skin")) idx=1;
                else if(t.equals("general")) idx=2;
                1
                if(isPatientFound && (assignedSlots.get(sl-1).get(idx)!=null && assignedSlots.get(sl-1).get(idx).pId==pid)){
                    assignedSlots.get(sl).set(idx,null);
                    System.out.println("This slot has been cancelled Successfully");
                }
                else {
                    System.out.println("Error: Entered details is Wrong");
                }
                break;
            case 7:
                System.out.println("Thank you for using the Municipal Hospital Management System.");
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
     }   
    }

}

 
