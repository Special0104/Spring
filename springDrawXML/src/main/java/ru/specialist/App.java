package ru.specialist;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        /*Point pt = context.getBean("myPoint", Point.class);
        Circle cr = context.getBean("myCircle", Circle.class);


        cr.setPt(pt);
        cr.draw();*/


        Scene scene = context.getBean("myScene", Scene.class);
        scene.draw();

        context.close();

    }

}