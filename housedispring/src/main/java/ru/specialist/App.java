package ru.specialist;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.specialist.Window;
import ru.specialist.House;


public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Window wnd = context.getBean("houseWindow", Window.class);
        House house = context.getBean("myHouse", House.class);

        house.setWindow(wnd);
        house.getWindow().open();
        context.close();

    }

}