package ru.specialist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BuilderConfig.class);



        /*Point pt = context.getBean("myPoint", Point.class);
        Circle cr = context.getBean("myCircle", Circle.class);


        cr.setPt(pt);
        cr.draw();*/


        Scene scene = context.getBean(Scene.class);
        scene.draw();

        context.close();

    }

}