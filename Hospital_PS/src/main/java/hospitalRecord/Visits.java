package hospitalRecord;
import java.time.LocalDate;
import java.util.List;

public class Visits {

	private LocalDate date;

	public Visits(LocalDate dates) {
		this.date = dates;
	}

	public LocalDate getDate() {
		return date;
	}

}
