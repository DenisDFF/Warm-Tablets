package com.github.denisdff.warmtables;

import com.github.denisdff.warmtables.Entity.Game;
import com.github.denisdff.warmtables.Entity.GameRules;
import com.github.denisdff.warmtables.Repository.GameDetailsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WarmTabletopsSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarmTabletopsSiteApplication.class, args);
	}
}

