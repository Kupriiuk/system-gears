package converter;

import converter.model.ConverterData;
import converter.model.Distance;
import converter.reader.DefaultReader;
import converter.reader.ExtensionReader;
import converter.service.impl.ConverterImpl;
import converter.writer.Writer;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String, Double> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your path to extension rules file :");
        String path = scanner.nextLine();

        ExtensionReader extensionReader = new ExtensionReader();
        List<Distance> extensionDistances = extensionReader.read(new File(path));
        extensionDistances.forEach(distance -> distanceToMap(distance));

        DefaultReader defaultReader = new DefaultReader();
        ConverterData data = defaultReader.read(new File("src/main/resources/task1/input.json"));
        ConverterImpl converter = new ConverterImpl();
        Distance distance1 = converter.convertUnit(data);

        Writer writer = new Writer();
        writer.write("src/main/resources/task1/output.json", distance1);
    }

    private static void distanceToMap(Distance distance) {
        map.put(distance.getUnit(), distance.getValue());
    }
}
