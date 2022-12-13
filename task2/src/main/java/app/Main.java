package app;

import app.reader.JsonReader;
import app.service.JsonComparator;
import app.service.JsonSorter;
import app.writer.JsonWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your path to input file :");
        String path = scanner.nextLine();

        JsonReader jsonReader = new JsonReader();
        JSONObject read = jsonReader.read(new File(path));
        JSONObject condition = (JSONObject) read.get("condition");
        JSONArray data = (JSONArray) read.get("data");
        String sortBy = String.valueOf(condition.get("sort_by"));
        JSONArray exclude = (JSONArray) condition.get("exclude");
        JSONObject jsonObject = (JSONObject) exclude.get(0);
        sortBy = sortBy.replaceAll("\\W+", "");

        JsonComparator jsonComparator = new JsonComparator();
        JsonSorter jsonSorter = new JsonSorter(jsonComparator);
        JSONArray excludeArray = jsonSorter.exclude(jsonObject, data);
        jsonComparator.setSortBy(sortBy);
        JSONArray jsonArray = jsonSorter.sortArray(excludeArray);
        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.write(jsonArray, new File("src/main/resources/task2/output.json"));
    }
}
