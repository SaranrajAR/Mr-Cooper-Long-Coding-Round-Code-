public class Doctor {
    private int docId;
    private String name;
    private String speciality;

    

    Doctor(int docId,String name,String speciality){
        this.docId = docId;
        this.name = name;
        this.speciality = speciality;
    }

    public void getDoctorDetails(){
        System.out.println("Doctor Id: "+docId);
        System.out.println("Doctor Name: "+name);
        System.out.println("Doctor Speciality: "+speciality);
    }

}
