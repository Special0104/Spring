package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.specialist.draw.Circle;
import ru.specialist.draw.Point;



@ComponentScan("ru.specialist.draw")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        Point pt = context.getBean(Point.class);
        Circle cr = context.getBean(Circle.class);
        cr.draw();

        //Создание дополнительного объекта и проверка Scope - prototype
        pt = context.getBean(Point.class);
        pt.draw();
        pt = context.getBean(Point.class);
        pt.draw();

    }
}
