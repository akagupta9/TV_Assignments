package hospitalRecord;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Patient {

	private String name;
	private String visitLocation;
	private List<Visits> allVisits;
	
	public Patient(String name, String visitLocation) {
		allVisits = new ArrayList<>();
		this.name = name;
		this.visitLocation = visitLocation;
	}

	public String getName() {
		return name;
	}

	public List<Visits> getAllVisits() {
		return allVisits;
	}

	public String getVisitLocation() {
		return visitLocation;
	}

	public void addVisit(Visits visit) {
		allVisits.add(visit);
	}

	public List<Visits> getVisit() {
		return allVisits;
	}

	public boolean isPatientLocal(String hospitalLocation) {
		return getVisitLocation().trim().equalsIgnoreCase(hospitalLocation);
	}
	
	public List<LocalDate> getAllVisitedDates() {
		return this.getAllVisits().stream().map(visit -> visit.getDate())
				.collect(Collectors.toList());
	}

	public boolean isPatientVistedAfter(LocalDate fromdate) {
		List<LocalDate> visitedDateAfter = getAllVisitedDates().stream()
				.filter(date -> date.isAfter(fromdate)).collect(Collectors.toList());
		return (visitedDateAfter.size() > 0) ? true : false;
	}

	public boolean isPatientVistedBefore(LocalDate toDate) {
		List<LocalDate> visitedDateBefore = getAllVisitedDates().stream()
				.filter(date -> date.isBefore(toDate)).collect(Collectors.toList());
		return (visitedDateBefore.size() > 0) ? true : false;
		
	}

	@Override
	public String toString() {
		return String.format("\n Patient Name : %s \n Visit Location: %s \n Visit Date: %s \n", getName(),
				getVisitLocation(), getAllVisitedDates().toString());
	}

}
