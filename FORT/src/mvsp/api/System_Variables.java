package mvsp.api;

public class System_Variables {
	public static class Appointments {
		public static String doctor_id;
		public static String json_datetime;

		public static String getJson_datetime() {
			return json_datetime;
		}

		public static void setJson_datetime(String json_datetime) {
			Appointments.json_datetime = json_datetime;
		}

		public static void setDoctor_id(String doctor_id) {
			Appointments.doctor_id = doctor_id;
		}

		public static String getDoctor_id() {
			return doctor_id;
		}

	}
}
