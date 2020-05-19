package sample.exercise21;

import java.io.Serializable;
import java.util.Comparator;

public class GeometricObjectComparator implements Comparator<GeometricObject>, Serializable {

    @Override
    public int compare(GeometricObject o1, GeometricObject o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}
