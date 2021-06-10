package ru.specialist;

import java.util.List;

public class Scene {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Shape> getObjects() {
        return objects;
    }

    public void setObjects(List<Shape> objects) {
        this.objects = objects;
    }

    List<Shape> objects;

    public void draw(){
        for (Shape sh: objects) {
            sh.draw();
        }
    }
}
