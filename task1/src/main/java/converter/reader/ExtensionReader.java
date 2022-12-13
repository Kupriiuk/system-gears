package converter.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import converter.model.Distance;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExtensionReader {

    public List<Distance> read(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Distance> readJson;

        try {
            readJson = objectMapper.readValue(file, new TypeReference<List<Distance>>(){});
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from extension-rules file ", e);
        }
        return readJson;
    }
}
