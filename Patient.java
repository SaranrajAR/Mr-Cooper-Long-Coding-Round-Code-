public class Patient {
    int pId;
    private String name;
    private int age;
    private String phone;
    
    Patient(int pId,String name,int age,String phone){
        this.pId = pId;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    public void getPatientDetails(){
        System.out.println();
        System.out.println();
        System.out.println("Patient Details: ");
        System.out.println();
        System.out.println("Patient Id: "+pId);
        System.out.println("Patient Name: "+name);
        System.out.println("Patient Age: "+age);
        System.out.println("Patient Phone: "+phone);
    }

}
