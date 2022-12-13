package converter.service.impl;

import converter.Main;
import converter.model.ConverterData;
import converter.model.Distance;
import converter.service.Converter;

public class ConverterImpl implements Converter {

    @Override
    public Distance convertUnit(ConverterData converterData) {
        String unit = converterData.getDistance().getUnit();
        Double indexTable = Main.map.get(converterData.getConvertTo());
        Double unitValue = Main.map.get(converterData.getDistance().getUnit());
        Double result = unitValue * converterData.getDistance().getValue();
        Distance resultDistance = new Distance();
        resultDistance.setUnit(converterData.getConvertTo());
        if (unit.equals(converterData.getConvertTo())) {
            return converterData.getDistance();
        }
        if (Main.map.containsKey(converterData.getConvertTo())) {
            if (unitValue < 1) {
                resultDistance.setValue(result * indexTable);
                return resultDistance;
            }
            resultDistance.setValue((result / indexTable));
        }
        return resultDistance;
    }
}
