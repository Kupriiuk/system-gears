package service;

import model.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointServiceImpl implements PointService {
    private static final int MAX_RAND_BOUND = 101;
    private static final int FIRST_STEP = 14;
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;
    private static final int Z_INDEX = 2;
    private static final int COORDINATES_COUNT = 3;
    private final List<Point> usedPoints = new ArrayList<>();

    private final Point finalPoint;

    public PointServiceImpl() {
        Random random = new Random();
        int x = random.nextInt(MAX_RAND_BOUND);
        int y = random.nextInt(MAX_RAND_BOUND);
        int z = random.nextInt(MAX_RAND_BOUND);
        finalPoint = new Point(x,y,z);
    }

    @Override
    public double getDistanceToFinalPoint(Point point) {
        int[] coordinates = point.getCoordinates();
        int[] finalCoordinates = finalPoint.getCoordinates();
        return Math.sqrt(
                Math.pow(coordinates[X_INDEX] - finalCoordinates[X_INDEX],2)
                + Math.pow(coordinates[Y_INDEX] - finalCoordinates[Y_INDEX],2)
                + Math.pow(coordinates[Z_INDEX] - finalCoordinates[Z_INDEX],2)
        );
    }

    @Override
    public List<Point> findFinalPoint(Point point) {
        for (int i = 0; i < COORDINATES_COUNT; i++) {
            findCoordinate(i,point);
        }
        return usedPoints;
    }

    private boolean isFinalCoordinateSmaller(int[] coordinates, int index, double distance) {
        if (coordinates[index] > 0) {
            coordinates[index] = coordinates[index] - 1;
            Point point = new Point(coordinates);
            usedPoints.add(point);
            double curDistance = getDistanceToFinalPoint(point);
            return curDistance < distance;
        }
        return false;
    }

    private List<Point> findCoordinate(int index, Point point){
        double distance = getDistanceToFinalPoint(point);
        double curDistance;
        double prevDistance = 0;
        int[] coordinates = point.getCoordinates();

        if (isFinalCoordinateSmaller(coordinates, index, distance)) {
            coordinates[index] = 0;
            point = new Point(coordinates);
            usedPoints.add(point);
            distance = getDistanceToFinalPoint(point);
        }
        for (int i = 0; i < FIRST_STEP; i++) {
            coordinates[index] = (coordinates[index] + (FIRST_STEP - i));
            point = new Point(coordinates);
            curDistance = getDistanceToFinalPoint(point);
            usedPoints.add(point);
            if (curDistance < distance) {
                prevDistance = distance;
                distance = curDistance;
            } else {
                if (prevDistance != 0 && curDistance >= prevDistance) {
                    coordinates[index] = (coordinates[index] - (FIRST_STEP - i));
                    distance = prevDistance;
                }
                coordinates[index] = (coordinates[index] - (FIRST_STEP - i));
                for(int y = 1; y < FIRST_STEP - i; y++){
                    coordinates[index] = coordinates[index] + 1;
                    point = new Point(coordinates);
                    curDistance = getDistanceToFinalPoint(point);
                    usedPoints.add(point);
                    if (curDistance < distance) {
                        distance = curDistance;
                    } else {
                        coordinates[index] = coordinates[index] - 1;
                        point = new Point(coordinates);
                        usedPoints.add(point);
                        return usedPoints;
                    }
                }
            }
        }
        return usedPoints;
    }
}
