package ft.patient;

public class Patient {
	private String patient_id;
	private String first_name;
	private String last_name;
	private String birth_date;
	private String passphrase;
	private String session_id;
	private String month;
	private String day;
	private String year;
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public Patient() {
		super();
	}

	public Patient(String patient_id, String first_name, String last_name,
			String birth_date, String passphrase, String session_id) {
		super();
		this.patient_id = patient_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birth_date = birth_date;
		this.passphrase = passphrase;
		this.session_id = session_id;
	}
}
