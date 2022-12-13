package model;

import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;

@Getter
@Setter
public class Point {
    int[] coordinates;

    public Point(int x, int y, int z) {
        coordinates = new int[] {x, y, z};
    }

    public Point(int[] coordinates) {
        this.coordinates = coordinates.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Arrays.equals(coordinates, point.coordinates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coordinates);
    }

    @Override
    public String toString() {
        return "Point{"
                + "coordinates=" + Arrays.toString(coordinates)
                + '}';
    }
}
