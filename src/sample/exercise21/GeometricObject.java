package sample.exercise21;

import java.util.Objects;

public abstract class GeometricObject {
    private final java.util.Date dateCreated;
    private String color = "white";
    private boolean filled;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public int hashCode() {
        return Objects.hashCode(getArea());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof GeometricObject)
            return getArea() == ((GeometricObject) o).getArea();
        return false;
    }
}
