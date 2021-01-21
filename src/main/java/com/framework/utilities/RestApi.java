package com.framework.utilities;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public interface RestApi {

  /**
   * Verify Response Status Code
   *
   * @param response: JSON response
   * @param statusCode: Status code to verify
   */
  default void verifyResponseStatusCode(Response response, String statusCode) {
    Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statusCode), "Status Code is not correct");
  }

  /**
   * Get Value from Response
   *
   * @param response: response
   * @param path: path to key
   * @return: value associated with key
   */
  default Object getValueFromResponse(Response response, String path) {
    JsonPath jsonPath = new JsonPath(response.asString());
    if (jsonPath.get(path) instanceof String) {
      return jsonPath.get(path);
    } else {
      ArrayList<String> list = jsonPath.get(path);
      Object value = list.get(0);
      return value;
    }
  }

  /**
   * Verify Key Data
   *
   * @param response: response
   * @param path: path to key
   * @param value: value to verify
   */
  default void verifyApiResponse(Response response, String path, Object value) {
    JsonPath jsonPath = new JsonPath(response.asString());
    boolean available = false;
    ArrayList<Object> list = jsonPath.get(path);
    for (Object v : list) {
      if (v instanceof Integer) {
        v = String.valueOf(v);
      }
      if (v != null && v.equals(value)) {
        available = true;
        break;
      }
    }
    Assert.assertTrue(available, "Value is not available");
  }

  /**
   * Verify data if it is available in Array
   *
   * @param response: api response
   * @param key: key to verify value
   * @param value: value
   */
  default void verifyDataIfItIsAvailableInArray(Response response, String key, Object value, String data) {
    boolean found = false;
    JsonPath jsonPath = new JsonPath(response.asString());
    if (jsonPath.get(data) instanceof HashMap) {
      if (((HashMap) jsonPath.get(data)).get(key).equals(value)) {
        found = true;
      }
    } else {
      List<HashMap<String, Object>> resultList = jsonPath.get(data);
      for (int i = 0; i < resultList.size(); i++) {
        Map<String, Object> m = resultList.get(i);
        if (m.get(key).equals(value)) {
          found = true;
          break;
        }
      }
    }
    Assert.assertTrue(found, "Value is not found");
  }

  /**
   * Verify Total number of Records returned in response
   *
   * @param response: response
   * @param path: path to key
   * @param expectedCount: expected count
   */
  default void verifyTotalNumberOfRecords(Response response, String path, int expectedCount) {
    JsonPath jsonPath = new JsonPath(response.asString());
    int size;
    if (jsonPath.get(path) instanceof Integer) {
      size = jsonPath.get(path);
    } else {
      size = ((ArrayList) jsonPath.get(path)).size();
    }
    Assert.assertEquals(size, expectedCount, "Count is not correct");
  }

  /**
   * Verify Key Data
   *
   * @param response: response
   * @param path: path to key
   * @param value: value to verify
   * @return: true if data is correct otherwise false
   */
  default void verifyApiData(Response response, String path, Object value) {
    response.then().body(path, equalTo(value));
  }

  /**
   * Send Post Request
   *
   * @param headers: Headers
   * @param requestURI: URI
   * @return: response
   */
  default Response sendPostRequest(Headers headers, JSONObject jsonObject, String requestURI) {
    return given().headers(headers).body(jsonObject.toString().replaceAll("\\\\", "")).when().post(requestURI);
  }

  /**
   * Send Get Request
   *
   * @param headers: Headers
   * @param requestURI: URI
   * @return: response
   */
  default Response sendGetRequest(Headers headers, String requestURI) {
    return given().headers(headers).when().get(requestURI);
  }

  /**
   * Send Delete Request
   *
   * @param headers: Headers
   * @param requestURI: URI
   * @return: response
   */
  default Response sendDeleteRequest(Headers headers, String requestURI) {
    return given().headers(headers).when().delete(requestURI);
  }

  /**
   * Send Put Request
   *
   * @param headers: Headers
   * @param requestURI: URI
   * @return: response
   */
  default Response sendPutRequest(Headers headers, JSONObject jsonObject, String requestURI) {
    return given().headers(headers).body(jsonObject.toString().replaceAll("\\\\", "")).when().put(requestURI);
  }

  /**
   * Send Patch Request
   *
   * @param headers: Headers
   * @param requestURI: URI
   * @return: response
   */
  default Response sendPatchRequest(Headers headers, JSONObject jsonObject, String requestURI) {
    return given().headers(headers).body(jsonObject.toString()).when().patch(requestURI);
  }



  default boolean verifyValueInResponse(Response response, String path, String key, Object value) throws Exception {
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
    Assert.assertTrue(isAvailable, "Value is not found");
    return isAvailable;
  }

  default boolean verifyValueInMap(HashMap<String, Object> map, String key, Object value) throws Exception {
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

  default boolean verifyValueInList(ArrayList list, String key, Object value) throws Exception {
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