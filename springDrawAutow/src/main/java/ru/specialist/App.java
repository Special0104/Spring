package ru.specialist;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.specialist.Circle;
import ru.specialist.Point;

//@ComponentScan("ru.specialist.draw")
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Point pt = context.getBean("myPoint", Point.class);
        Circle cr = context.getBean("myCircle", Circle.class);

        pt.draw();
        cr.draw();

        context.close();


    }
}
