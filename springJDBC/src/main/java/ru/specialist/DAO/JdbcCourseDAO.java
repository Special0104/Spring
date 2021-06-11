package ru.specialist.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class CourseRowMapper implements RowMapper<Course> {
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course c = new Course();
        c.setId(rs.getInt("id"));
        c.setTitle(rs.getString("title"));
        c.setLength(rs.getInt("length"));
        c.setDescription(rs.getString("description"));
        return c;
    }

}

// Реализуем интерфейс DAO
public class JdbcCourseDAO implements CourseDAO {
    private static final String SQL_SELECT_COURSE =
            "SELECT id, title, length, description FROM courses";
    private static final String SQL_SELECT_COURSE_BY_ID =
            SQL_SELECT_COURSE + " WHERE id = ?";
    private static final String SQL_SELECT_COURSE_BY_TITLE =
            SQL_SELECT_COURSE + " WHERE title = ?";
    private static final String SQL_INSERT_COURSE =
          //  "INSERT INTO Courses (title,length,description) VALUES (:title, :length, :description)";
     		"INSERT INTO Courses (title,length,description) VALUES (?,?,?)";



    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Course> findAll() {

        // Вручную получаю данные из таблиц и сохраняю в объекты списка
		/*
		List<Course> courses= new ArrayList<Course>();
		List<Map<String,Object>> rows = 
				getJdbcTemplate().queryForList(SQL_SELECT_COURSE);
		for (Map<String,Object> row : rows) {
			Course c= new Course();
			c.setId((int)(row.get("id")));
			c.setTitle((String)(row.get("title")));
			c.setLength((int)(row.get("length")));
			c.setDescription((String)(row.get("description")));
			courses.add(c);
		}*/
        //При соответствии наименований полей и названий столбцов в таблице можно применять Mapper
        List<Course> courses = getJdbcTemplate().query(SQL_SELECT_COURSE,
                new BeanPropertyRowMapper(Course.class));

        return courses;
    }

    public Course findById(int id) {
        Course course = (Course) getJdbcTemplate().queryForObject(
                SQL_SELECT_COURSE_BY_ID, new Object[]{id},
                new CourseRowMapper());
        return course;

    }

    public List<Course> findByTitle(String title) {
		List<Course> courses= new ArrayList<Course>();
		List<Map<String,Object>> rows =
				getJdbcTemplate().queryForList(SQL_SELECT_COURSE_BY_TITLE, new Object[]{title});
		for (Map<String,Object> row : rows) {
			Course c= new Course();
			c.setId((int)(row.get("id")));
			c.setTitle((String)(row.get("title")));
			c.setLength((int)(row.get("length")));
			c.setDescription((String)(row.get("description")));
			courses.add(c);
		}
		return courses;
    }

    public void insert(Course course){
		jdbcTemplate.update(
				SQL_INSERT_COURSE,
				course.getTitle(), course.getLength(), course.getDescription()
		);

	}
}