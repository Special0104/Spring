package ru.specialist.JDBC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.DAO.Course;
import ru.specialist.DAO.CourseDAO;

public class App 
{
    public static void main( String[] args )
    {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDAO courseDao = context.getBean(CourseDAO.class);

		/*Тесты выборки:
		//1. Выборка всех курсов.
		/*for(Course c : courseDao.findAll())
			System.out.println(c);*/

		//2. Выборка по индексу.
		//System.out.println(courseDao.findById(5));

		//3. Выборка по заголовку.
		/*for(Course c : courseDao.findByTitle("Spring"))
			System.out.println(c); */

		//4. Вставка в базу сущности.
		Course c= new Course();

		c.setTitle("PM");
		c.setLength(4);
		c.setDescription("Project Managment");
		courseDao.insert(c);

		for(Course el: courseDao.findAll())
			System.out.println(el);

		context.close();
    }
}
