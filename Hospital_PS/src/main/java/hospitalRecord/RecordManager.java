package hospitalRecord;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import utilities.CustomTypes.HospitalLocation;

public class RecordManager {

	public static void main(String[] arg) {
		Hospital hospital = new Hospital(HospitalLocation.BANGALORE);
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
				
				System.out.println("Visit Date 1 (In Format YYYY-MM-DD): ");
				String date1 = sc.next();
				
				Visits visit1 = new Visits(LocalDate.parse(date1));
				System.out.println("Visit Date 2 (In Format YYYY-MM-DD): ");
				String date2 = sc.next();
				Visits visit2 = new Visits(LocalDate.parse(date2));
				
				Patient patient= new Patient(name, HospitalLocation.BANGALORE);
				patient.addVisit(visit2);
				patient.addVisit(visit1);
				
				hospital.addPatient(patient);
				break;

			case 2:
				System.out.println("Patients Details: ");
				List<Patient> patients = hospital.getPatients();
				for (Patient patient1 : patients) {
					System.out.println(patient1.toString());
				}
				break;

			case 3:
				System.out.println("Enter From Date : ");
				String fromDate = sc.next();
				System.out.println("Enter To Date : ");
				String toDate = sc.next();
				double filteredResult = hospital.getLocalPatientsPercentage(LocalDate.parse(fromDate), LocalDate.parse(toDate));
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
