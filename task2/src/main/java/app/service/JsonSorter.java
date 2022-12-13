package app.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSorter {
    private final JsonComparator jsonArrayComparator;

    public JsonSorter(JsonComparator jsonArrayComparator) {
        this.jsonArrayComparator = jsonArrayComparator;
    }

    public JSONArray sortArray(JSONArray jsonArray) {

        JSONObject object;
        for (int i = 0; i < jsonArray.size() - 1; i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i + 1);
            if (jsonArrayComparator.compare(jsonObject, jsonObject1) > 0) {
                object = jsonObject;
                jsonArray.remove(i);
                jsonArray.add(i, jsonObject1);
                jsonArray.remove(i + 1);
                jsonArray.add(i + 1, object);
            }
        }
        return jsonArray;
    }

    public JSONArray include(JSONObject includeBy, JSONArray jsonArray) {
        JSONArray result = new JSONArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if (jsonObject.get(includeBy.keySet().toArray()[0]) == includeBy.values().toArray()[0]) {
                result.add(jsonObject);
            }
        }
        return result;
    }

    public JSONArray exclude(JSONObject excludeBy, JSONArray jsonArray) {
        JSONArray result = new JSONArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if (jsonObject.get(excludeBy.keySet().toArray()[0]) != excludeBy.values().toArray()[0]) {
                result.add(jsonObject);
            }
        }
        return result;
    }
}
