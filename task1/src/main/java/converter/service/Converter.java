package converter.service;

import converter.model.ConverterData;
import converter.model.Distance;

public interface Converter {
    Distance convertUnit(ConverterData converterData);
}
