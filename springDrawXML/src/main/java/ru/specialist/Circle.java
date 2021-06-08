package ru.specialist;

public class Circle extends Shape {
    private Point pt;
    private int r;

    public Point getPt() {
        return pt;
    }

    public void setPt(Point pt) {
        this.pt = pt;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }



    public Circle() {
    }

    public Circle(Point pt, int r) {
        this.pt = pt;
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.printf("Окружность нарисована (x = %d, y = %d, r = %d)\n", pt.getX(), pt.getY(), getR());

    }
}



