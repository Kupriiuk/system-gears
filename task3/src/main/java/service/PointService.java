package service;

import model.Point;
import java.util.List;

public interface PointService {
    double getDistanceToFinalPoint(Point point);
    List<Point> findFinalPoint(Point point);
}
