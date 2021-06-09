package ru.specialist.drw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myPoint")
@Scope("prototype")
public class Point {

    @Value("#{coordsRdm}")
    private Coords coordsPoint;

    public Coords getCoordsPoint() {
        return coordsPoint;
    }

    public void setCoordsPoint(Coords cd) {
        this.coordsPoint = cd;
    }

    public Point() {

    }

    //@Autowired
    public Point(Coords cd) {
        this.coordsPoint = cd;
    }

    public void draw() {
        System.out.printf("Точка нарисована (x = %d, y = %d)\n", coordsPoint.getX(), coordsPoint.getY());
        System.out.println(this.toString());
    }


}
