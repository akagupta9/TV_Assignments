import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Patient {

	private String name;
	private String visitLocation;
	private List<Visits> allVisits;
	
	public Patient() {
		// TODO Auto-generated constructor stub
		allVisits = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Visits> getAllVisits() {
		return allVisits;
	}

	public void setAllVisits(List<Visits> allVisits) {
		this.allVisits = allVisits;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitLocation() {
		return visitLocation;
	}

	public void setVisitLocation(String visitLocation) {
		this.visitLocation = visitLocation;
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

	public boolean isPatientVistedAfter(String fromdate) {
		List<LocalDate> visitedDateAfter = getAllVisitedDates().stream()
				.filter(date -> date.isAfter(LocalDate.parse(fromdate))).collect(Collectors.toList());
		return (visitedDateAfter.size() > 0) ? true : false;
	}

	public boolean isPatientVistedBefore(String toDate) {
		List<LocalDate> visitedDateBefore = getAllVisitedDates().stream()
				.filter(date -> date.isBefore(LocalDate.parse(toDate))).collect(Collectors.toList());
		return (visitedDateBefore.size() > 0) ? true : false;
		
	}

	@Override
	public String toString() {
		return String.format("\n Patient Name : %s \n Visit Location: %s \n Visit Date: %s \n", getName(),
				getVisitLocation(), getAllVisitedDates().toString());
	}

}
