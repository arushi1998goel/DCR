package com.framework.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonFileUtil {

	/**
	 * read json file content from file
	 * 
	 * @param fileName:
	 *            it contains file name
	 * @param input:
	 *            set flag value for input of output file
	 * @return : it will return JSON object of content
	 * @throws Exception
	 */
	public static JSONObject readJsonData(String folderName, String fileName) throws Exception {
		if (fileName.isEmpty() || fileName == null)
			throw new Exception("Please provide valid file name");
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		Object obj = null;
		try {
			obj = parser.parse(new FileReader(folderName + "/" + fileName + ".json"));
			jsonObject = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static JSONObject updatePoiJsonInput(JSONObject json, String key, String value) throws Exception {
		if (key.equals("id")) {
			return JsonFileUtil.updateJsonValue(json, key, value + Utilities.getTimeStamp());
		} else {
			JSONObject jsonObj = JsonFileUtil.updateJsonValue(json, "id", "poi" + Utilities.getTimeStamp());
			return JsonFileUtil.updateJsonValue(jsonObj, key, value);
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static JSONObject updateJsonValue(JSONObject json, String key, String value) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, String> properties = ((Map<String, String>) json.get("properties"));
		properties.put(key, value);
		return json;
	}

	/**
	 * Update Json file content for Object and array type both
	 * 
	 * @param json
	 *            : Object of json content
	 * @param key
	 *            : Keys of json data which need to update
	 * @param value
	 *            : values of key
	 * @return is return object
	 * @throws Exception
	 */
	public static Object updateJsonValue(Object json, String key, String value) throws Exception {
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		if (json instanceof JSONArray) {
			// It's an array
			jsonArray = (JSONArray) json;
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject obj = (JSONObject) jsonArray.get(i);
				updateJsonValue(obj, key, value + i);
			}
		} else if (json instanceof JSONObject) {
			// It's an object
			jsonObject = (JSONObject) json;
			return (Object) updateJsonValue(jsonObject, key, value);
		} else {
			throw new Exception("Please provide valied Json");
		}
		return json;
	}
	/**
	 * Update Json value if key is in Array
	 *
	 * @param json: json object
	 * @param map: to update values
	 * @param arrayName: array name under which you have to update value
	 * @return: JSON object
	 */
	public static JSONObject updateJsonValueInArray(JSONObject json, HashMap<String, Object> map, String arrayName) {
		JSONArray array = (JSONArray) json.get(arrayName);
		for (int i = 0; i < array.size(); i++) {
			JSONObject itemArr = (JSONObject) array.get(i);
			for (Map.Entry<String, Object> m : map.entrySet()) {
				itemArr.put(m.getKey(), m.getValue());
			}
		}
		return json;
	}

	public static JSONObject updateJsonValueInArrayContainingHashMap(JSONObject json, HashMap<String, Object> map, String arrayName, String list) {
		JSONArray array = (JSONArray) json.get(arrayName);
		for (int i = 0; i < array.size(); i++) {
			HashMap<String, Object> arr = (HashMap) array.get(i);
			HashMap<String, Object> hashMap = (HashMap) arr.get(list);
			for (Map.Entry<String, Object> m : map.entrySet()) {
				hashMap.put(m.getKey(), m.getValue());
			}
		}
		return json;
	}

	/**
	 * @param json: json object
	 * @param elementsToAdd: to add elements in array
	 * @param arrayName: under which we want to add element
	 * @param list: list name under which array is available
	 */
	public static JSONObject addElementsInArrayInJson(JSONObject json, ArrayList<String> elementsToAdd, String arrayName, String list) {
		JSONObject jsonObject = (JSONObject) json.get(list);
		JSONArray jsonArray = (JSONArray) jsonObject.get(arrayName);
		for (String l : elementsToAdd) {
			jsonArray.add(l);
		}
		return json;
	}

	/**
	 * Update Json value if key is in list
	 *
	 * @param json: json object
	 * @param map: to update values
	 * @param list: list name under which you have to update value
	 * @return: JSON object
	 */
	public static JSONObject updateJsonValueInList(JSONObject json, HashMap<String, Object> map, String list) {
		JSONObject jsonObject = (JSONObject) json.get(list);
		for (Map.Entry<String, Object> m : map.entrySet()) {
			jsonObject.put(m.getKey(), m.getValue());
		}
		return json;
	}

	/**
	 * Verify that response contains json value
	 *
	 * @param response : response object
	 * @param path     : josn node path
	 * @param key      : node name for which we required to check value
	 * @param value    : Node value
	 * @return : It will return true if json node value exist and return false if
	 *         value not exist
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean verifyValueInResponse(Response response, String path, String key, Object value)
			throws Exception {
		boolean isAvailable = false;
		JsonPath jsonPath = new JsonPath(response.asString());
		Object object = jsonPath.getJsonObject(path);
		if (object instanceof HashMap) {
			isAvailable = verifyValueInMap((HashMap<String, Object>) object, key, value);
		} else if (object instanceof ArrayList) {
			isAvailable = verifyValueInList((ArrayList) object, key, value);
		} else {
			if (object.equals(value)) {
				isAvailable = true;
			}
		}
		Assert.assertTrue("Value " + value + " not found for node " + key, isAvailable);
		return isAvailable;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean verifyValueInMap(HashMap<String, Object> map, String key, Object value) throws Exception {
		boolean isAvailable = false;
		for (Map.Entry<String, Object> m : map.entrySet()) {
			Object object = m.getKey();
			if (object instanceof HashMap) {
				isAvailable = verifyValueInMap((HashMap<String, Object>) object, key, value);
				if (isAvailable) {
					break;
				}
			} else if (object instanceof ArrayList) {
				isAvailable = verifyValueInList((ArrayList) object, key, value);
				if (isAvailable) {
					break;
				}
			} else {
				if (m.getKey().equals(key)) {
					if (m.getValue() instanceof ArrayList) {
						isAvailable = verifyValueInList((ArrayList) m.getValue(), key, value);
						if (isAvailable) {
							break;
						}
					} else if (m.getValue() instanceof HashMap) {
						isAvailable = verifyValueInMap((HashMap<String, Object>) m.getValue(), key, value);
						if (isAvailable) {
							break;
						}
					} else {
						if (value == null && m.getValue() == null) {
							isAvailable = true;
							break;
						} else if (m.getValue().equals(value)) {
							isAvailable = true;
							break;
						}
					}
				}
			}
		}
		return isAvailable;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean verifyValueInList(ArrayList list, String key, Object value) throws Exception {
		boolean isAvailable = false;
		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);
			if (object instanceof HashMap) {
				isAvailable = verifyValueInMap((HashMap<String, Object>) object, key, value);
				if (isAvailable) {
					break;
				}
			} else if (object instanceof ArrayList) {
				isAvailable = verifyValueInList((ArrayList) object, key, value);
				if (isAvailable) {
					break;
				}
			} else {
				if (object != null) {
					if (object.equals(value)) {
						isAvailable = true;
						break;
					}
				}
			}
		}
		return isAvailable;
	}


}
