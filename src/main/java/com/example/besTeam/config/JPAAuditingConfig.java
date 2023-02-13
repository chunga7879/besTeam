package com.example.besTeam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Spring container can process the class and generate Spring Beans to be used in the application.
@Configuration
@EnableJpaAuditing
public class JPAAuditingConfig {
}
