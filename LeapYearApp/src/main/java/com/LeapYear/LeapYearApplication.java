package com.LeapYear;

import com.LeapYear.Core.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeapYearApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeapYearApplication.class, args);
		Main main = new Main();
		main.startGame();
	}

}
