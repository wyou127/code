package code;

/**
 * Created: 9/2/14 2:07 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */

public class MaxPointOnALine {
    public static void main(String[] args) {
        MaxPointOnALine maxPointOnALine = new MaxPointOnALine();
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        Point d = new Point(3, 2);
        Point e = new Point(1, 0);
        Point f = new Point(2, 0);
        Point g = new Point(3, 0);
        Point h = new Point(4, 0);
        Point i = new Point(5, 0);
        Point j = new Point(6, 0);


        Point[] points = {a, b, c, d, e, f, g, h, i, j};
        System.out.println(maxPointOnALine.maxPoints(points));
    }

    public int maxPoints(Point[] points) {
        if(points.length==1)
            return 1;
        Map<Double, Map<Point, Set<Point>>> pointInLine = new HashMap<Double, Map<Point, Set<Point>>>();
        for (int i = 0; i < points.length; i++) {
            Point start = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point end = points[j];
                double result = calculate(start, end);
                Map<Point, Set<Point>> pointMap;
                Set<Point> pointSet;
                if (pointInLine.containsKey(result)) {
                    pointMap = pointInLine.get(result);
                    if (pointMap.containsKey(start)) {
                        pointSet = pointMap.get(start);
                    } else {
                        pointSet = new HashSet<Point>();
                    }


                } else {
                    pointMap = new HashMap<Point, Set<Point>>();
                    pointSet = new HashSet<Point>();
                }
                pointSet.add(start);
                pointSet.add(end);
                pointMap.put(start, pointSet);
                pointInLine.put(result, pointMap);
            }
        }

        int max = 0;
        for (Map.Entry<Double, Map<Point, Set<Point>>> entry : pointInLine.entrySet()) {
            for (Map.Entry<Point, Set<Point>> innerEntry : entry.getValue().entrySet()) {
                max = max > innerEntry.getValue().size() ? max : innerEntry.getValue().size();
            }
        }
        return max;
    }

    private double calculate(Point start, Point end) {
        return ((end.y - start.y) * 1.0 / (end.x - start.x));
    }
}
