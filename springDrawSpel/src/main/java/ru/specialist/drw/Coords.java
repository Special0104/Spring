package ru.specialist.drw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("coordsRdm")
@Scope("prototype")
public class Coords {
    @Value("#{T(java.lang.Math).random()*1000}")
    private int x;

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

    @Value("#{T(java.lang.Math).random()*1000}")
    private int y;

    Coords() {
    }

    Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.printf("Координата создана (x = %d, y = %d)\n", getX(), getY());
        System.out.println(this.toString());
    }

}
