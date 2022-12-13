package converter.writer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import converter.model.Distance;

public class Writer {
    public void write(String path, Distance distance) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), distance);
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file");
        }
    }
}
