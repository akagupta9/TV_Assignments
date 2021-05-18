import java.time.LocalDate;

public class Patient {

    private String name;
    private String visitLocation;
    private String visitDate;

    public String getName() {
        return name;
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

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public boolean isPatientLocal() {
        return getVisitLocation().trim().equalsIgnoreCase("Bangalore");
    }

    public boolean isPatientVistedAfter(String fromdate) {
        return LocalDate.parse(this.getVisitDate()).isAfter(LocalDate.parse(fromdate));
    }

    public boolean isPatientVistedBefore(String toDate) {
        return LocalDate.parse(this.getVisitDate()).isBefore(LocalDate.parse(toDate));
    }

    @Override
    public String toString() {
        return String.format("\n Patient Name : %s \n Visit Location: %s \n Visit Date: %s \n", getName(), getVisitLocation(), getVisitDate());
    }

}
