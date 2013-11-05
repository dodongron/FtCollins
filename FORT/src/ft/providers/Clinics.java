package ft.providers;

import java.util.ArrayList;
import java.util.List;

public class Clinics {

	private String clinic_id;
	private String clinic_name;

	public Clinics() {
		super();
	}

	public Clinics(String clinic_id, String clinic_name) {
		super();
		this.clinic_id = clinic_id;
		this.clinic_name = clinic_name;
	}

	public String getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
	}

	public String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public static List<Clinics> get_clinics() {
		List<Clinics> datas = new ArrayList<Clinics>();
		for (int i = 0; i < 10; i++) {
			String clinic_id = "CLINIC" + i;
			String clinic_name = "CLINIC" + i;
			Clinics clinic = new Clinics(clinic_id, clinic_name);
			datas.add(clinic);
		}
		return datas;
	}
}
