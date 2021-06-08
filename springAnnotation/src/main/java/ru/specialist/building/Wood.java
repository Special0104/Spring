package ru.specialist.building;

import org.springframework.stereotype.Component;

@Component("logsBean")
public class Wood implements Material{

	public void cover() {
		System.out.println("Класть бревна");
		
	}

}
