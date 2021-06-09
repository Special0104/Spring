package ru.specialist.program;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.specialist.drw.Circle;
import ru.specialist.drw.Coords;
import ru.specialist.drw.Point;

@ComponentScan("ru.specialist.drw")
public class App {
    public static void main(String[] args) {
       /* ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");*/
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        Coords cd = context.getBean("coordsRdm", Coords.class);
        Point pt = context.getBean("myPoint", Point.class);
        Circle cr = context.getBean("myCircle", Circle.class);
        cd.draw();
        pt.draw();
        cr.draw();


        //context.close();
    }
}

