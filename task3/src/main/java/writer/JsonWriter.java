package writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ResultJsonPoint;
import java.io.File;
import java.io.IOException;

public class JsonWriter {
    public void write(String path, ResultJsonPoint resultJsonPoint) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), resultJsonPoint);
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file");
        }
    }
}
