import java.util.List;
import java.util.Scanner;

public class RecordManager {

    public static void main(String[] arg) {
        Hospital hospital = new Hospital();
        while (true) {
            System.out.println("_____WELCOME TO HOSPITAL___");
            System.out.println("1. Add Patient");
            System.out.println("2. Get All Patients Details");
            System.out.println("3. Get Percent count of Local and Outside Patients");
            System.out.println("4. Exit");
            System.out.println("____________________________");
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Select an Option:");
            int selectedOption = sc.nextInt();

            switch (selectedOption) {
                case 1:
                    System.out.println("PLease Enter Patients Details : ");
                    System.out.println("Patient Name : ");
                    String name = sc.next();
                    System.out.println("Visit Location : ");
                    String location = sc.next();
                    System.out.println("Date (In Format YYYY-MM-DD): ");
                    String date = sc.next();
                    
                    Patient patient = new Patient();
                    patient.setName(name);
                    patient.setVisitDate(date);
                    patient.setVisitLocation(location);
                    hospital.addPatient(patient);
                    break;

                case 2:
                    System.out.println("Patients Details: ");
                    List<Patient> patients = hospital.getPatients();
                    for (Patient patient1: patients){
                        System.out.println(patient1.toString());
                    }
                    break;

                case 3:
                    System.out.println("Enter From Date : ");
                    String fromDate = sc.next();
                    System.out.println("Enter To Date : ");
                    String toDate = sc.next();
                    double filteredResult = hospital.getLocalPatientsPercentage(fromDate,toDate);
                    System.out.println(String.format("Local Patient Percent is %s %", filteredResult));
                    break;

                case 4:
                    System.exit(1);
                    break;

                default:
                    System.out.println("Please Choose Valid Options");
                    break;
            }
        }
    }

}
