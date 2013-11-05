package test.src;


public class JsonToArray {
	public static void main(String[] args) {
		String s = "{'title': [{'name':'john', 'age': 44}, {'name':'Alex','age':11}]}";
//		parseProfilesJson(s);
	}
//	public static void parseProfilesJson(String the_json) {
//		try {
//			JSONObject myjson = new JSONObject(the_json);
//			JSONArray the_json_array = myjson.getJSONArray("title");
//			int size = the_json_array.length();
//		    ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
//		    for (int i = 0; i < size; i++) {
//		        JSONObject another_json_object = the_json_array.getJSONObject(i);
//		            arrays.add(another_json_object);
//		            System.out.println(another_json_object);
//		    }
//		JSONObject[] jsons = new JSONObject[arrays.size()];
//		arrays.toArray(jsons);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//	}
}
