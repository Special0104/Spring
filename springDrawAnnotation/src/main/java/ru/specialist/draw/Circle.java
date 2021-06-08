package ru.specialist.draw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCircle")
@Scope("prototype")
public class Circle {

    private Point pt;
    private int r;

    public Point getPt() {
        return pt;
    }

    @Value("#{myPoint}") //
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


    public void draw() {
        System.out.printf("Окружность нарисована (x = %d, y = %d, r = %d)\n", pt.getX(), pt.getY(), getR());
        System.out.println(this.toString());
    }
}



