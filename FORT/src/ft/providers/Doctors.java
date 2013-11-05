package ft.providers;

import java.util.ArrayList;
import java.util.List;

public class Doctors {
	private String doctor_id;
	private String doctor_name;
	private String clinic_id;
	private String clinic_name;

	public Doctors() {
		super();
	}

	public Doctors(String doctor_id, String doctor_name, String clinic_id,
			String clinic_name) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.clinic_id = clinic_id;
		this.clinic_name = clinic_name;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
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

	public static List<Doctors> get_doctors() {
		List<Doctors> datas = new ArrayList<Doctors>();
		for (int i = 0; i < 10; i++) {
			String doctor_id = "DOCTOR" + i;
			String doctor_name = "DOCTOR" + i;
			String clinic_id = "CLINIC" + i;
			String clinic_name = "CLINIC" + i;
			Doctors doc = new Doctors(doctor_id, doctor_name, clinic_id,
					clinic_name);
			datas.add(doc);
		}
		return datas;
	}
}
