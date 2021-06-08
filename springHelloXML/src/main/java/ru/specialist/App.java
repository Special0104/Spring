package ru.specialist;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        PersonBean person = context.getBean("PersonBean", PersonBean.class);

        //System.out.printf("%s - %d\n", person.getName(), person.getAge());
        System.out.println(person);

        context.close();
    }
}
