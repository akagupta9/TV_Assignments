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
        patient.setVisitDate("2021-04-01");
		boolean isPatientVisitedAfterDate = patient.isPatientVistedAfter("2020-12-01");
        Assert.assertTrue(isPatientVisitedAfterDate);
        
        isPatientVisitedAfterDate = patient.isPatientVistedAfter("2021-12-01");
        Assert.assertFalse(isPatientVisitedAfterDate);
		
	}
	
	@Test
	public void validatePatientVisitBeforeDate() {

		patient.setName("Patient 2");
        patient.setVisitDate("2021-04-01");
		boolean isPatientVistedBefore = patient.isPatientVistedBefore("2021-12-01");
        Assert.assertTrue(isPatientVistedBefore);
        
        isPatientVistedBefore = patient.isPatientVistedBefore("2020-12-01");
        Assert.assertFalse(isPatientVistedBefore);
		
	}


}
