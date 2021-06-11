package ru.specialist.dbHibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDAO;

public class App 
{
    public static void main( String[] args )
    {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CourseDAO courseDao = context.getBean("courseDao", CourseDAO.class);
		//Работа с Hibernate
		//1. Вставка и удаление из базы данных.
		/*
		Course spring = new Course();
		spring.setTitle("Spring");
		spring.setLength(40);
		spring.setDescription("Spring framework");
		courseDao.insert(spring);
		courseDao.delete(8);
		*/
		//2. Выборка всех данных
		for(Course c : courseDao.findAll())
			System.out.println(c);

		//3. Поиск по Id
		//Course c8 = courseDao.findById(8);
		//System.out.println( c8 );
		//c8.setLength(45);
		//courseDao.update(c8);

		//3. Поиск по заголовку
		for(Course c : courseDao.findByName("Spring"))
			System.out.println(c);


		context.close();
	}
}
