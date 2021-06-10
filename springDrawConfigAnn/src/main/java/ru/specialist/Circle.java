package ru.specialist;

import org.springframework.beans.factory.annotation.Autowired;

public class Circle extends Shape {
    @Autowired
    private Point myPoint;

    private int r;

    public Point getMyPoint() {
        return myPoint;
    }

    public void setMyPoint(Point pt) {
        this.myPoint = pt;
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
        this.myPoint = pt;
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.printf("Окружность нарисована (x = %d, y = %d, r = %d)\n", myPoint.getX(), myPoint.getY(), getR());

    }
}



