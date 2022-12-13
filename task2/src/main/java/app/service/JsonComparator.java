package app.service;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

import java.util.Comparator;

@Setter
@Getter
public class JsonComparator  implements Comparator<JSONObject> {
    private String sortBy;

    @Override
    public int compare(JSONObject o1, JSONObject o2) {
        return o1.get(sortBy).toString().compareTo(o2.get(sortBy).toString());
    }
}
