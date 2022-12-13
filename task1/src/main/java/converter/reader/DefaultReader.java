package converter.reader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import converter.model.ConverterData;

public class DefaultReader {

    public ConverterData read(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        ConverterData readJson;
        try {
            readJson = objectMapper.readValue(file, ConverterData.class);
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file ", e);
        }
        return readJson;
    }
}
