package app.reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public JSONObject read(File file) {
        JSONParser jsonParser = new JSONParser();
        try(FileReader fileReader = new FileReader(file)) {
            JSONObject parse = (JSONObject) jsonParser.parse(fileReader);
            return parse;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
