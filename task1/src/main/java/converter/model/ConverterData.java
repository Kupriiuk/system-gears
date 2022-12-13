package converter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConverterData {

    private Distance distance;
    @JsonProperty("convert_to")
    private String convertTo;
}
