package ru.specialist;

public class Point extends Shape {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

   public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }
    @Override
    public void draw(){
        System.out.printf("Точка нарисована (x = %d, y = %d)\n", getX(), getY());
    }




}
