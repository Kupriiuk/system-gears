import model.Point;
import model.ResultJsonPoint;
import service.PointService;
import service.PointServiceImpl;
import writer.JsonWriter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your x coordinate");
        int x = scanner.nextInt();
        System.out.println("Enter your y coordinate");
        int y = scanner.nextInt();
        System.out.println("Enter your z coordinate");
        int z = scanner.nextInt();

        PointService pointService = new PointServiceImpl();
        Point point = new Point(x,y,z);
        List<Point> finalPoint = pointService.findFinalPoint(point);

        ResultJsonPoint resultJsonPoint = new ResultJsonPoint();
        resultJsonPoint.setCalls(finalPoint.size() - 1);
        resultJsonPoint.setSearch_points(finalPoint);
        resultJsonPoint.setRandom_point(finalPoint.get(0));

        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.write("src/main/resources/task3/output.json",resultJsonPoint);
    }
}
