package ru.specialist.drw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCircle")
@Scope("prototype")
public class Circle {

    /*@Autowired
    @Qualifier("coordsRdm")*/
    @Value("#{coordsRdm}")
    private Coords centerCoords;

    @Value("#{" +
            "T(java.lang.Math).sqrt(" +
                "T(java.lang.Math).pow(coordsRdm.getX(), 2) + T(java.lang.Math).pow(coordsRdm.getY(), 2)" +
            ")" +
            "}")
    //@Value("1000")
    private int r;

    public Coords getCenterCoords() {
        return centerCoords;
    }

    public void setCenterCoords(Coords cd) {
        this.centerCoords = cd;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Circle() {
    }

    public Circle(Coords cd, int r) {
        this.centerCoords = cd;
        this.r = r;
    }


    public void draw() {
        System.out.printf("Окружность нарисована (x = %d, y = %d, r = %d)\n", centerCoords.getX(), centerCoords.getY(), getR());
        System.out.println(this.toString());
    }
}



