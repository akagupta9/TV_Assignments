import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientTest {

	Patient patient;

	@BeforeClass
	public void setUp() {
		patient = new Patient();
	}

	@Test
	public void validatePatientVisitAfterDate() {

		patient.setName("Patient 1");
		patient.setVisitLocation("Delhi");
		Visits visit1 = new Visits();
		visit1.setDate(LocalDate.parse("2021-01-01"));
		patient.addVisit(visit1);

		Visits visit2 = new Visits();
		visit2.setDate(LocalDate.parse("2022-01-01"));
		patient.addVisit(visit2);

		boolean isPatientVisitedAfterDate = patient.isPatientVistedAfter("2021-12-01");
		Assert.assertTrue(isPatientVisitedAfterDate);

		isPatientVisitedAfterDate = patient.isPatientVistedAfter("2023-12-01");
		Assert.assertFalse(isPatientVisitedAfterDate);

	}

	@Test
	public void validatePatientVisitBeforeDate() {

		patient.setName("Patient 2");
		patient.setVisitLocation("Bangalore");
		Visits visit1 = new Visits();
		visit1.setDate(LocalDate.parse("2021-01-01"));
		patient.addVisit(visit1);

		Visits visit2 = new Visits();
		visit2.setDate(LocalDate.parse("2019-01-01"));
		patient.addVisit(visit2);

		boolean isPatientVistedBefore = patient.isPatientVistedBefore("2021-01-01");
		Assert.assertTrue(isPatientVistedBefore);

		isPatientVistedBefore = patient.isPatientVistedBefore("2010-12-01");
		Assert.assertFalse(isPatientVistedBefore);

	}

}
