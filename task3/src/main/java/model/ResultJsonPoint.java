package model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class ResultJsonPoint {
    private Point random_point;
    private List<Point> search_points;
    private int calls;
}
