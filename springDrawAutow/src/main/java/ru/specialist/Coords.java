package ru.specialist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("myCoords")
//@Scope("prototype")
public class Coords {
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

    private int y;

    Coords(){

    }

    Coords(int x, int y){
        this.x = x;
        this.y = y;
    }
}
