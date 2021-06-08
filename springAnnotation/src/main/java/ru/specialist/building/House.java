package ru.specialist.building;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class House{
	private Window window;
	
	//private Collection<Door> doors;
	//private List<Door> doors;
	//private Door[] doors;
	
	private Map<String,Door> doors;
	
	//@Autowired(required=false)
	//@Autowired
	//@WoodQualifier
	//@Qualifier("logs")
	@Inject // javax.inject
	@Named("logsBean") // javax.inject
	private Material wall;
	
	@Value("3") // можно указывать SpEL !!
	private int height;
	
	@Autowired
	public House(Window window) {
		this.window = window;
	}
	
	public void view() {
		window.open();
	}
	
	public void buildWall() {
		for(int i=1; i <= getHeight(); i++) {
			System.out.printf("Этаж %d. ", i);
			wall.cover();
		}
	}
	
	public void installDoors() {
		//for(Door door : doors)
		//	door.install();
		
		for(Map.Entry<String, Door> e : doors.entrySet()) {
			System.out.printf("Ключ %s. ", e.getKey());
			e.getValue().install();
		}
			
	}
	

	public Material getWall() {
		return wall;
	}

	//@Autowired
	//@Qualifier("logsBean")
	//@Qualifier("logs")
	public void setWall(Material wall) {
		this.wall = wall;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	public Map<String,Door> getDoors() {
		return doors;
	}

	public void setDoors(Map<String,Door> doors) {
		this.doors = doors;
	}

	
	/*public Collection<Door> getDoors() {
		return doors;
	}

	public void setDoors(Collection<Door> doors) {
		this.doors = doors;
	}*/
	
	
	
	
	
	
	
}
