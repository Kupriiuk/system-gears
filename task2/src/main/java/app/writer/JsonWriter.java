package app.writer;

import org.json.simple.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public void write(JSONArray jsonArray, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
