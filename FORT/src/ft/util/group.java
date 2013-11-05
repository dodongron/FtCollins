package ft.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import ft.util.group.doctor;

public class group {

	public static class doctor {
		private String clinic_id;
		private String clinic_name;

		public doctor(String clinic_id, String clinic_name) {
			this.clinic_id = clinic_id;
			this.clinic_name = clinic_name;
		}

		public String getClinic_id() {
			return clinic_id;
		}

		public String getClinic_name() {
			return clinic_name;
		}

	}

	public static void main(String[] args) {
		List<doctor> datas = new ArrayList<doctor>();
		datas.add(new doctor("1", ""));
		datas.add(new doctor("1", ""));
		datas.add(new doctor("2", ""));
		datas.add(new doctor("3", ""));
		datas.add(new doctor("2", ""));
		datas.add(new doctor("5", ""));
		datas.add(new doctor("1", ""));
		datas.add(new doctor("4", ""));
		List<doctor> new_list = new ArrayList<doctor>();
		int i=0;
		for(doctor d:datas){
			if(i==0){
				new_list.add(d);
			}else{
				Iterator<doctor> itr = new_list.iterator();
				int exists=0;
				while (itr.hasNext()) {
					doctor doc = itr.next();
					if(d.clinic_id.equals(doc.clinic_id)){
						exists=1;
						break;
					}
				}
				if(exists==0){
					new_list.add(d);
				}
			}
			
			i++;
		}		
		for(doctor d:new_list){
			System.out.println(d.clinic_id);
		}
	}
}
